package com.keshavdking.instagramclone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.parse.ParseUser;

public class welcome extends AppCompatActivity {


    private Toolbar mToolbar;
    private TabAdaptor mTabAdaptor;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setTitle("Social Media App!! Welcome:"+ ParseUser.getCurrentUser().get("username"));
        mToolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(mToolbar);
        mTabAdaptor=new TabAdaptor(getSupportFragmentManager());
        mTabLayout=findViewById(R.id.tabLayout);
        mViewPager=findViewById(R.id.viewPager);

        mViewPager.setAdapter(mTabAdaptor);
        mTabLayout.setupWithViewPager(mViewPager,true);

//        TextView welcomeText = findViewById(R.id.welcomeTxt);
//        Intent i = getIntent();
//        welcomeText.setText("Welcome "+i.getStringExtra("username")+" Nice to have you back!!");
//  another way of doing things
//        welcomeText.setText("Welcome "+ ParseUser.getCurrentUser().get("username"));
//        Button btnLogOut=findViewById(R.id.btnLogOut);
//        btnLogOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
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
//                ParseUser.logOut();
//                finish();
//            }
//        });


    }
}