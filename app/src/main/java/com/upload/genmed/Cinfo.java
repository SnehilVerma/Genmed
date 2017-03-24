package com.upload.genmed;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cinfo extends Activity {


    String[] compinfo = new String[4];
    String[] e2=new String[4];


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.comp_view);

        Bundle bundle = getIntent().getExtras();

        String med2 = bundle.getString("key");
        Toast t = Toast.makeText(Cinfo.this, med2, Toast.LENGTH_SHORT);
        t.show();


        compinfo = queryDatabase2(med2);
        if(compinfo[0]==null){
            Toast t2 = Toast.makeText(Cinfo.this, "company info unavailable", Toast.LENGTH_SHORT);
            t2.show();}

        else{
            display(compinfo);
        }



    }


    private String[] queryDatabase2(String med) {

        try {

            dbhandler entry = new dbhandler(Cinfo.this);
            entry.open();


            e2 = entry.searchComp(med);



            entry.close();


        } catch (Exception e) {
            System.out.println(e);
        }

        return (e2);


    }


    public void display(String[] compinfo){
        TextView m1 = (TextView) findViewById(R.id.textView21);
        TextView m2 = (TextView) findViewById(R.id.textView22);
        TextView m3 = (TextView) findViewById(R.id.textView23);
        TextView m4 = (TextView) findViewById(R.id.textView24);
        m1.setText(compinfo[0]);
        m2.setText(compinfo[1]);
        m3.setText(compinfo[2]);
        m4.setText(compinfo[3]);



            Toast t = Toast.makeText(Cinfo.this, "Search successful", Toast.LENGTH_SHORT);
            t.show();}












}
