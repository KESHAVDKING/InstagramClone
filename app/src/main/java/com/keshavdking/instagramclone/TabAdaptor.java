package com.keshavdking.instagramclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdaptor extends FragmentPagerAdapter {
    public TabAdaptor(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ProfileTab profileTab=new ProfileTab();
                return profileTab;

            case 1:
                UserTab userTab =new UserTab();
                return userTab;
            case 2:
                return new ImageShareTab();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "Profile";
            case 1 :
                return "Users";
            case 2:
                return "Shared Images";
            default:
                return null;

        }

    }
}
