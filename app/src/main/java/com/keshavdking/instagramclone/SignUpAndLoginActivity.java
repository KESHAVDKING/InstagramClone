package com.keshavdking.instagramclone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpAndLoginActivity  extends AppCompatActivity {
    private EditText usernameSignup,passwordSignup,emailSignup;
    Button btnSignup,btnLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_login_activity);
        usernameSignup=findViewById(R.id.edtUsernameSignup);
        passwordSignup=findViewById(R.id.edtPasswordsignup);
        //since after password we need to add enter functionality so
        passwordSignup.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode== KeyEvent.KEYCODE_ENTER && keyEvent.getAction()==KeyEvent.ACTION_DOWN){

                  btnSignup.callOnClick();
                }

                return false;
            }
        });

        emailSignup=findViewById(R.id.edtEmailSignup);
        setTitle("SignUp");
                //        usernameLogin=findViewById(R.id.edtUsernameLogin);
//        passwordLogin=findViewById(R.id.edtPasswordLogin);

        if (ParseUser.getCurrentUser()!=null){
//            ParseUser.getCurrentUser().logOut();
        transitionToWelcomePage();
        }
        btnSignup=findViewById(R.id.btnSignup_Signup);
        btnLogin=findViewById(R.id.btnlogin_signup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (emailSignup.getText().toString().equals("") || usernameSignup.getText().toString().equals("") || passwordSignup.getText().toString().equals("")) {
                    FancyToast.makeText(SignUpAndLoginActivity.this, "Emailid,Username,Password Can't be empty!!", FancyToast.LENGTH_SHORT, FancyToast.WARNING, true).show();

                } else {

                    ParseUser user = new ParseUser();
                    user.setUsername(usernameSignup.getText().toString());
                    user.setPassword(passwordSignup.getText().toString());
                    user.setEmail(emailSignup.getText().toString());
                    final ProgressDialog progressDialog = new ProgressDialog(SignUpAndLoginActivity.this);
                    progressDialog.setMessage("SigningUp " + usernameSignup.getText().toString());
                    progressDialog.show();
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                FancyToast.makeText(SignUpAndLoginActivity.this, usernameSignup.getText().toString() + " is added successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                               transitionToWelcomePage();
                            } else {

                                FancyToast.makeText(SignUpAndLoginActivity.this, e.getMessage() + "failed to add", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();
                        }
                    });
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(SignUpAndLoginActivity.this,Login.class);
                startActivity(i);

//                ParseUser.logInInBackground(usernameLogin.getText().toString(), passwordLogin.getText().toString(), new LogInCallback() {
//                    @Override
//                    public void done(ParseUser user, ParseException e) {
//                        if (user!=null && e==null){
//                            FancyToast.makeText(SignUpAndLoginActivity.this,user.get("username")+" is logged in successfully", FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
//
//                            Intent intent = new Intent(SignUpAndLoginActivity.this,welcome.class);
//                            intent.putExtra("username",user.get("username").toString());
//
//                            startActivity(intent);
//
//                        }else {
//                            FancyToast.makeText(SignUpAndLoginActivity.this,e.getMessage(), FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
//
//                        }
//                    }
//                });

            }
        });


    }
    public void emptyAreaIsTapped(View view){
        try {
            InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    private void transitionToWelcomePage(){
        Intent intent = new Intent(SignUpAndLoginActivity.this, welcome.class);
//                                intent.putExtra("username", usernameSignup.getText().toString());

        startActivity(intent);
    }
}
