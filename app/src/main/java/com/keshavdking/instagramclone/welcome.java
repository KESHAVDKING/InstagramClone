package com.keshavdking.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setTitle("Welcome"+ParseUser.getCurrentUser().get("username"));

        TextView welcomeText = findViewById(R.id.welcomeTxt);
        Intent i = getIntent();
//        welcomeText.setText("Welcome "+i.getStringExtra("username")+" Nice to have you back!!");
//  another way of doing things
        welcomeText.setText("Welcome "+ ParseUser.getCurrentUser().get("username"));
        Button btnLogOut=findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ParseUser.logOutInBackground(new LogOutCallback() {
//                    @Override
//                    public void done(ParseException e) {
//                        if (e==null) {
//                            FancyToast.makeText(welcome.this,ParseUser.getCurrentUser().get("username")+" is logged out successfully", FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
//                            Intent i = new Intent(welcome.this,SignUpAndLoginActivity.class);
//                            startActivity(i);
//
//
//                        }else {
//                            FancyToast.makeText(welcome.this,"Could not logged out ", FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
//
//                        }
//                    }
//                });
                ParseUser.logOut();
                finish();
            }
        });


    }
}