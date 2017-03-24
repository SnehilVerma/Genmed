package com.upload.genmed;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class showResults extends ListActivity {

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storeres);


        /*Bundle bundle = getIntent().getExtras();

        String med = bundle.getString("key");
        Toast t=Toast.makeText(showResults.this,med,Toast.LENGTH_SHORT);
        t.show();

            try {
            dbhandler entry = new dbhandler(showResults.this);
            entry.open();
            String medinfo[];
            medinfo = entry.searchStore(med);

            TextView m1 = (TextView) findViewById(R.id.textView10);
            TextView m2 = (TextView) findViewById(R.id.textView21);
            TextView m3 = (TextView) findViewById(R.id.textView22);
           // TextView m4 = (TextView) findViewById(R.id.m4);
            m1.setText(medinfo[0]);
            m2.setText(medinfo[1]);
            m3.setText(medinfo[2]);
            //m4.setText(medinfo[3]);
            Toast t2 = Toast.makeText(showResults.this, medinfo[0], Toast.LENGTH_SHORT);
            t2.show();


            entry.close();



        } catch (Exception e) {
            System.out.println(e);
        }

    }
}*/


    ArrayList<String> storeinfo = new ArrayList<>();
    ArrayList<String> e2 = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);



        Bundle bundle = getIntent().getExtras();

        String med = bundle.getString("key");
        Toast t = Toast.makeText(showResults.this, med, Toast.LENGTH_SHORT);
        t.show();
        storeinfo = queryDatabase(med);
//        String s2=storeinfo.get(0).toString();
        // Toast t2 = Toast.makeText(showResults.this,s2, Toast.LENGTH_SHORT);
        // t2.show();
        displayResult();

    }

    private void displayResult() {


        TextView tView = new TextView(this);
        tView.setText(" SHOP NAME           LOCATION           AVAILABILITY ");

        getListView().addHeaderView(tView);

        setListAdapter(new ArrayAdapter<>(this,
                R.layout.listview,R.id.output, storeinfo));
        getListView().setTextFilterEnabled(true);

    }


    private ArrayList<String> queryDatabase(String med) {

        try {

            dbhandler entry = new dbhandler(showResults.this);
            entry.open();


            e2 = entry.searchStore(med);


            entry.close();


        } catch (Exception e) {
            System.out.println(e);
        }

        return (e2);


    }
}


