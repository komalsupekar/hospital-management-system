package com.hospital.komal.Patient.View_Report;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hospital.komal.R;

/**
 * Created by komal on 027-Sep-2019.
 */
public class Final_View_Report extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_view_report);

        Bundle bb = getIntent().getExtras();
        String report = bb.getString("report");
        TextView final_report = (TextView) findViewById(R.id.tv_report);
        final_report.setText(report);

    }

}
