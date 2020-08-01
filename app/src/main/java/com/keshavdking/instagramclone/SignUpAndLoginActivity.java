package com.keshavdking.instagramclone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpAndLoginActivity  extends AppCompatActivity {
    private EditText usernameSignup,passwordSignup,usernameLogin,passwordLogin;
    Button btnSignup,btnLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_login_activity);
        usernameSignup=findViewById(R.id.edtUsernameSignup);
        passwordSignup=findViewById(R.id.edtPasswordSignup);
        usernameLogin=findViewById(R.id.edtUsernameLogin);
        passwordLogin=findViewById(R.id.edtPasswordLogin);
        btnSignup=findViewById(R.id.btnSignup);
        btnLogin=findViewById(R.id.btnSignIn);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ParseUser user=new ParseUser();
                user.setUsername(usernameSignup.getText().toString());
                user.setPassword(passwordSignup.getText().toString());
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null){
                            FancyToast.makeText(SignUpAndLoginActivity.this,usernameSignup.getText().toString()+" is added successfully", FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                        }else {

                            FancyToast.makeText(SignUpAndLoginActivity.this,e.getMessage()+"failed to add", FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                        e.printStackTrace();
                        }
                    }
                });
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ParseUser.logInInBackground(usernameLogin.getText().toString(), passwordLogin.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user!=null && e==null){
                            FancyToast.makeText(SignUpAndLoginActivity.this,user.get("username")+" is logged in successfully", FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();

                        }else {
                            FancyToast.makeText(SignUpAndLoginActivity.this,e.getMessage(), FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();

                        }
                    }
                });

            }
        });


    }
}
