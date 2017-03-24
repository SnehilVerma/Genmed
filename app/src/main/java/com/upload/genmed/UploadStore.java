package com.upload.genmed;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UploadStore extends Activity {
    EditText t1;
    EditText t2;
    EditText t3;
    EditText t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.uploadstore);

        t1=(EditText)findViewById(R.id.gname);
        t2=(EditText)findViewById(R.id.shop);
        t3=(EditText)findViewById(R.id.loc);
        t4=(EditText)findViewById(R.id.avail);




    }

    public void uploadshop(View view){


        boolean done=true;
        try {
            String gen = t1.getText().toString();
            String shop= t2.getText().toString();
            String loc = t3.getText().toString();
            String av=t4.getText().toString();
            dbhandler entry = new dbhandler(UploadStore.this);
            entry.open();
            entry.createStore(gen,shop,loc,av);
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

}
