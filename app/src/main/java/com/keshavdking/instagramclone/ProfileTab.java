package com.keshavdking.instagramclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileTab extends Fragment {

    private EditText profileName,profileBio,profileHobbies,profileProfession,profileFavSports;
    private Button btnUpdateInfo;
    private ParseUser mParseUser=ParseUser.getCurrentUser();

    public ProfileTab() {
        // Required empty public constructor
    }

        // TODO: Rename and change types and number of parameters
    public static ProfileTab newInstance() {
        ProfileTab fragment = new ProfileTab();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_tab, container, false);
        profileName=view.findViewById(R.id.edtProfileName);
        profileBio=view.findViewById(R.id.edtProfileBioText);
        profileProfession=view.findViewById(R.id.edtProfileProfession);
        profileHobbies=view.findViewById(R.id.edtProfileHobbies);
        profileFavSports=view.findViewById(R.id.edtProfileFavSports);
        btnUpdateInfo=view.findViewById(R.id.btnUpdateinfo);

        if (mParseUser.get("profileName")==null){
            profileName.setText("");
        }else {
            profileName.setText(mParseUser.get("profileName").toString());
        }
        if (mParseUser.get("profileBio")==null){
            profileBio.setText("");
        }else {
            profileBio.setText(mParseUser.get("profileBio").toString());
        }
        if (mParseUser.get("profileProfession")==null){
            profileProfession.setText("");
        }else {
            profileProfession.setText(mParseUser.get("profileProfession").toString());
        }
        if (mParseUser.get("profileHobbies")==null){
            profileHobbies.setText("");
        }else {
            profileHobbies.setText(mParseUser.get("profileHobbies").toString());
        }
        if (mParseUser.get("profilefavSports")==null){
            profileFavSports.setText("");
        }else {
            profileFavSports.setText(mParseUser.get("profilefavSports").toString());
        }
        btnUpdateInfo.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                mParseUser.put("profileName",profileName.getText().toString());
                mParseUser.put("profileBio",profileBio.getText().toString());
                mParseUser.put("profileProfession",profileProfession.getText().toString());
                mParseUser.put("profileHobbies",profileHobbies.getText().toString());
                mParseUser.put("profilefavSports",profileFavSports.getText().toString());


                mParseUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                              FancyToast.makeText(getContext(),ParseUser.getCurrentUser().get("username")+" Profile Saved successfully", FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();

                        }else
                        {
                              FancyToast.makeText(getContext(),e.getMessage(), FancyToast.LENGTH_LONG,FancyToast.WARNING,true).show();

                        }
                    }
                });
            }
        });
        return view;
    }

}