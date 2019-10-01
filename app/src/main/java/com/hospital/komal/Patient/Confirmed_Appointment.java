package com.hospital.komal.Patient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hospital.komal.R;

/**
 * Created by komal on 28-Sep-2019.
 */
public class Confirmed_Appointment extends AppCompatActivity {

    String username,password,user_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmed_appointment);

        Bundle bb = getIntent().getExtras();
        username = bb.getString("username");
        password = bb.getString("password");
        user_type = bb.getString("user_type");
    }
}
