package com.upload.genmed;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Broker extends Activity {

    EditText t1;
    EditText t2;
    EditText t3;

    EditText t4;
    EditText t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.broker_view);

        t1 = (EditText) findViewById(R.id.gname);
        t2 = (EditText) findViewById(R.id.shop);
        t3 = (EditText) findViewById(R.id.medg);


        t4 = (EditText) findViewById(R.id.genn);
        t5 = (EditText) findViewById(R.id.genc);

    }

    ///upload med///


    public void uploadmed(View view) {
        boolean done = true;
        try {
            String med = t1.getText().toString();
            String cost = t2.getText().toString();
            String gen_name = t3.getText().toString();

            dbhandler entry = new dbhandler(Broker.this);
            entry.open();
            entry.createMed(med, cost, gen_name);
            entry.close();

        } catch (Exception e) {
            done = false;
            String error = e.toString();
            Dialog d = new Dialog(this);
            d.setTitle("oops");

            TextView tv = new TextView(this);
            tv.setText(error);
            d.setContentView(tv);
            d.show();

        } finally {
            if (done) {
                Dialog d = new Dialog(this);
                d.setTitle("Yeah!! database updated");

                TextView tv = new TextView(this);
                tv.setText("success");
                d.setContentView(tv);
                d.show();
            }
        }


    }

    public void uploadgen(View view) {
        boolean done = true;
        try {
            String gen = t4.getText().toString();
            String cost = t5.getText().toString();

            dbhandler entry = new dbhandler(Broker.this);
            entry.open();
            entry.createGen(gen, cost);
            entry.close();

        } catch (Exception e) {
            done = false;
            String error = e.toString();
            Dialog d = new Dialog(this);
            d.setTitle("oops");

            TextView tv = new TextView(this);
            tv.setText(error);
            d.setContentView(tv);
            d.show();

        } finally {
            if (done) {
                Dialog d = new Dialog(this);
                d.setTitle("Yeah!! database updated");

                TextView tv = new TextView(this);
                tv.setText("success");
                d.setContentView(tv);
                d.show();
            }
        }


    }


    public void uploadstore(View view) {
        Intent i=new Intent(this,UploadStore.class);
        startActivity(i);
    }

}