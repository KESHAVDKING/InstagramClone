package com.keshavdking.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class app extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

                Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("AATsbfvO6UqnghuBWhDD7yF0SSDPTjjvC900EYFp")
                        // if defined
                        .clientKey("9oSoAFqEh9BMGeeS0IlGxZiOcgF499oFcqgVLh6I")
                        .server("https://parseapi.back4app.com/")
                        .build()
                );

        }
    }

