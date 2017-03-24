package com.upload.genmed;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.SQLException;

public class SignupView extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.signupview);
        TextView tv2=(TextView)findViewById(R.id.textView3);
        dbhandler info=new dbhandler(this);
        try {
            info.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String data=info.getData();
        info.close();
        tv2.setText(data);

    }
}
