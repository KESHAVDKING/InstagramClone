package com.keshavdking.instagramclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserTab extends Fragment {


    private ListView mListView;
    private ArrayList arraylist;
    private ArrayAdapter arrayAdaptor;


       public UserTab() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static UserTab newInstance() {
        UserTab fragment = new UserTab();
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
        View view= inflater.inflate(R.layout.fragment_user_tab, container, false);
        mListView=view.findViewById(R.id.listView);
        arraylist = new ArrayList();
        arrayAdaptor = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arraylist);

        final TextView loadingUsers = view.findViewById(R.id.edtLoadingUsers);
        ParseQuery<ParseUser> parseQuery = ParseUser.getQuery();
        parseQuery.whereNotEqualTo("username",ParseUser.getCurrentUser().getUsername());
        parseQuery.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if (e==null){
                    if(objects.size()>0){
                        for (ParseUser user:objects){
                            arraylist.add(user.getUsername());
                        }
                        mListView.setAdapter(arrayAdaptor);
                        loadingUsers.animate().alpha(0).setDuration(2000);
                        mListView.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

       return view;
       }
}