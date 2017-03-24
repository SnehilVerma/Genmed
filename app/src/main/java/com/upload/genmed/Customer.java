package com.upload.genmed;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Customer extends Activity {

    String med;
    TextView t1;
    EditText t2;
    String med2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.cust_view);

    }


    public void searchgen(View view) throws Exception{

        EditText tu = (EditText) findViewById(R.id.medicine);
        med = tu.getText().toString();
        if(med.equals("") || med.equals(" ") ){
            Toast t=Toast.makeText(Customer.this,"Enter medicine first",Toast.LENGTH_SHORT);
            t.show();
        }
        else {
            gotodb(med);
        }


        ///// remove comments to enable////
        /*try {
            dbhandler entry = new dbhandler(Customer.this);
            entry.open();
            EditText tu = (EditText) findViewById(R.id.medicine);
            String med = tu.getText().toString();

            String medinfo[] = new String[4];
            medinfo = entry.search(med);

            TextView m1 = (TextView) findViewById(R.id.m1);
            TextView m2 = (TextView) findViewById(R.id.m2);
            TextView m3 = (TextView) findViewById(R.id.m3);
            TextView m4 = (TextView) findViewById(R.id.m4);
            m1.setText(medinfo[0]);
            m2.setText(medinfo[1]);
            m3.setText(medinfo[2]);
            m4.setText(medinfo[3]);
            Toast t = Toast.makeText(Customer.this, medinfo[0], Toast.LENGTH_SHORT);
            t.show();


            entry.close();



        } catch (Exception e) {
            System.out.println(e);
        }
        */



    }

    /////////////// progressDialog shit /////////////////temporary function///////
    private class Fetchresults extends AsyncTask<String,Void,String[]> {

        ProgressDialog mProgressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
           mProgressDialog = new ProgressDialog(Customer.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Fetching results!");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected String[] doInBackground(String... name) {

            //String medinfo[];
            String name1 = name[0];
            String medinfo[] = new String[4];

            try {
                Thread.sleep(2000);
                try {

                    dbhandler entry = new dbhandler(Customer.this);
                    entry.open();


                    medinfo = entry.search(name1);


                    entry.close();


                } catch (Exception e) {
                    System.out.println(e);
                }


            } catch (InterruptedException e) {
                System.out.print(e);
            }
            return medinfo;
        }



        @Override
        protected void onPostExecute(String[] medinfo) {
            // Set the bitmap into ImageView
            mProgressDialog.dismiss();
            TextView m1 = (TextView) findViewById(R.id.m1);
            TextView m2 = (TextView) findViewById(R.id.m2);
            TextView m3 = (TextView) findViewById(R.id.m3);
            TextView m4 = (TextView) findViewById(R.id.m4);

            if(medinfo[0]==null){
                Toast t = Toast.makeText(Customer.this, "medicine not found", Toast.LENGTH_SHORT);
                t.show();}


            else{
                m1.setText(medinfo[0]);
                m2.setText(medinfo[1]);
                m3.setText(medinfo[2]);
                m4.setText(medinfo[3]);
            Toast t = Toast.makeText(Customer.this, "Search successful", Toast.LENGTH_SHORT);
            t.show();}
            // Close progressdialog


        }
    }

    public void gotodb(String name){
        new Fetchresults().execute(name);
    }


    public void showStore(View view){
        Intent i=new Intent(this,showResults.class);
        t1 = (TextView) findViewById(R.id.m3);
        med = t1.getText().toString();
        i.putExtra("key",med);
        startActivity(i);
    ///continue from here/////////
    }


    public void search_comp(View view){
        Intent i=new Intent(this,Cinfo.class);
        t2 = (EditText) findViewById(R.id.medicine);
        med2 = t2.getText().toString();
        i.putExtra("key",med2);
        startActivity(i);
        ///continue from here/////////
    }

}