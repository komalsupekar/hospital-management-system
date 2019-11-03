package com.hospital.komal;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hospital.komal.Patient.Confirmed_Appointment;
import com.hospital.komal.Patient.New_Appointment;
import com.hospital.komal.Patient.Wait_Appointment;

/**
 * Created by komal on 28-Sep-2019.
 */
public class Personal_Info extends AppCompatActivity {

    String username,password,user_type;
    DatabaseHelper db;
    TextView name,age,gender,dob,bgroup,utype,city,pincode,mobno,uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);
        db = new DatabaseHelper(this);

        Bundle bb = getIntent().getExtras();
        username = bb.getString("username");
        password = bb.getString("password");
        user_type = bb.getString("user_type");

        name = (TextView) findViewById(R.id.name);
        age = (TextView) findViewById(R.id.age);
        gender = (TextView) findViewById(R.id.gender);
        dob = (TextView) findViewById(R.id.dob);
        bgroup = (TextView) findViewById(R.id.bgroup);
        utype = (TextView) findViewById(R.id.utype);
        city = (TextView) findViewById(R.id.city);
        pincode = (TextView) findViewById(R.id.pincode);
        mobno = (TextView) findViewById(R.id.tv_mno);
        uname = (TextView) findViewById(R.id.username);

        Cursor y = db.checkduplicates_in_user_credentials(username, password, getResources().getString(R.string.user_credentials));

        if (y.moveToFirst()) {
            String name1 = y.getString(1);
            String name2 = y.getString(2);

            name.setText(name1+" "+name2);
            age.setText(y.getString(3));
            gender.setText(y.getString(6));
            dob.setText(y.getString(5));
            bgroup.setText(y.getString(4));
            utype.setText(y.getString(7));
            city.setText(y.getString(8));
            pincode.setText(y.getString(9));
            mobno.setText(y.getString(10));
            uname.setText(y.getString(12));
        }
    }

    public void update(View view){

        Intent i;
        Bundle b = new Bundle();
        b.putString("username",username);
        b.putString("password",password);
        b.putString("user_type",user_type);

        i = new Intent(Personal_Info.this, Update.class);
        i.putExtras(b);
        startActivity(i);
        finish();
    }
}
