package com.upload.genmed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Activity {

    String userdata;
    Bundle user_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.login);

        user_input=getIntent().getExtras();
        userdata=user_input.getString("profile");



    }




    public void signup(View view){
        Intent i1=new Intent(this,Signup.class);
        startActivity(i1);

    }

    public void login(View view){
        try {
            dbhandler entry = new dbhandler(Login.this);
            entry.open();
            EditText tu = (EditText) findViewById(R.id.username);
            String user = tu.getText().toString();

            EditText tp = (EditText) findViewById(R.id.avail);
            String pass = tp.getText().toString();

            if (user.equals("") || pass.equals("")) {
                Toast t = Toast.makeText(Login.this, "No username/password entered", Toast.LENGTH_SHORT);
                t.show();
            }
            else {


                String pass2 = entry.searchPass(user);
                //  TextView rp=(TextView)findViewById(R.id.passret);
                // rp.setText(pass2);


                if (pass2.equals(pass)) {

                    if (userdata.equals("two")) {
                        call_brok();
                    } else

                        call_cust();


                } else {
                    Toast t = Toast.makeText(Login.this, "Password or username is wrong", Toast.LENGTH_SHORT);
                    t.show();

                }

                entry.close();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }





    }







    public void call_cust(){
        Intent i2=new Intent(this,Customer.class);
        startActivity(i2);


    }
    public void call_brok(){
        Intent i3 = new Intent(this, Broker.class);
        startActivity(i3);

    }
}
