package com.keshavdking.instagramclone;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity {
    private EditText name,kickSpeed,punchSpeed,punchPower,kickPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name=findViewById(R.id.name);
        kickPower=findViewById(R.id.kickPower);
        kickSpeed=findViewById(R.id.kickSpeed);
        punchPower=findViewById(R.id.punchPower);
        punchSpeed=findViewById(R.id.punchSpeed);
    }

    public void helloWorldIsTapped(View view){

        final ParseObject kickBoxer = new ParseObject("KickBoxer");
        kickBoxer.put("name",name.getText().toString());
        kickBoxer.put("punchSpeed",Integer.parseInt(punchSpeed.getText().toString()));
        kickBoxer.put("punchPower",Integer.parseInt(punchPower.getText().toString()));
        kickBoxer.put("kickSpeed",Integer.parseInt(kickSpeed.getText().toString()));
        kickBoxer.put("kickPower",Integer.parseInt(kickPower.getText().toString()));
        kickBoxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e==null){
                    FancyToast.makeText(SignUp.this,kickBoxer.get("name")+"is added to the server",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                }else {
                    FancyToast.makeText(SignUp.this,"Error while adding to server",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                }
            }
        });
    }
}