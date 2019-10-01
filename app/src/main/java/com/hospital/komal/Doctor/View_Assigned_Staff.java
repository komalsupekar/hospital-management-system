package com.hospital.komal.Doctor;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hospital.komal.DatabaseHelper;
import com.hospital.komal.Message;
import com.hospital.komal.R;

import java.util.ArrayList;

/**
 * Created by Neeraj on 09-Apr-16.
 */
public class View_Assigned_Staff extends AppCompatActivity {

    String username, password, user_type;
    DatabaseHelper dbh = new DatabaseHelper(this);
    ArrayList<String> d_name = new ArrayList<>();
    ListView lv_bills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_assigned_staff);

        Bundle bb = getIntent().getExtras();
        username = bb.getString("username");
        password = bb.getString("password");
        user_type = bb.getString("user_type");

        lv_bills = (ListView) findViewById(R.id.lv_assigned_staff);

        Cursor y = dbh.checkduplicates_in_user_credentials("", "", getResources().getString(R.string.staff));

        if (y.moveToFirst()) {
            while (true) {
                if (y.getString(4).equals("Y")) {

                    DatabaseHelper dbh1 = new DatabaseHelper(this);
                    Cursor z1 = dbh1.checkduplicates_in_user_credentials(y.getString(0), y.getString(1), getResources().getString(R.string.user_credentials));

                    if (z1.moveToNext()) {
                        d_name.add(z1.getString(1) + " " + z1.getString(2));
                    }
                }

                if (y.isLast())
                    break;
                y.moveToNext();
            }

            ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, d_name);
            lv_bills.setAdapter(adapter);
        } else {
            Message.message(View_Assigned_Staff.this, "Sorry You have No Staff Right, Now");
            finish();
        }
    }
}
