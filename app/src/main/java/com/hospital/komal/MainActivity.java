package com.hospital.komal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    Button Bloginregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SET UP THE DATABASE
        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();


    }

    public void emergency(View view)
    {
        Intent h= new Intent(getApplicationContext(), emegency.class);
        startActivity(h);
    }

    public void login(View view)
    {
        Intent i = new Intent(MainActivity.this, Login.class);
        startActivity(i);
    }

    public void availDoctors(View view) {
        Intent i = new Intent(MainActivity.this, Doctors_available.class);
        startActivity(i);
    }
    public void availServices(View view) {
        Intent i = new Intent(MainActivity.this, Services_offered.class);
        startActivity(i);
    }

    public void help(View view){
        Intent i = new Intent(MainActivity.this,Help.class);
        startActivity(i);
    }
}
