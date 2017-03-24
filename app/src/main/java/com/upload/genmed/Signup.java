package com.upload.genmed;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Signup extends Activity {

    EditText t1;
    EditText t2;
    EditText t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.signup);


        t1=(EditText)findViewById(R.id.username);
        t2=(EditText)findViewById(R.id.password);
        t3=(EditText)findViewById(R.id.profile);

    }


    public void register(View view) {
        boolean done=true;
        try {
            String username = t1.getText().toString();
            String password = t2.getText().toString();
            String prof = t3.getText().toString();
            dbhandler entry = new dbhandler(Signup.this);
            entry.open();
            entry.createRecord(username, password, prof);
            entry.close();

        } catch (Exception e) {
            done=false;
            String error=e.toString();
            Dialog d=new Dialog(this);
            d.setTitle("oops");

            TextView tv=new TextView(this);
            tv.setText(error);
            d.setContentView(tv);
            d.show();

        }
        finally {
            if(done){
                Dialog d=new Dialog(this);
                d.setTitle("Yeah!! database updated");

                TextView tv=new TextView(this);
                tv.setText("success");
                d.setContentView(tv);
                d.show();
            }
        }





        }

    public void viewdb(View view){

        Intent i=new Intent(this,SignupView.class);
        startActivity(i);

    }

}



