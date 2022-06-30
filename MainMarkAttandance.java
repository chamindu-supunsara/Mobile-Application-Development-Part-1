package com.example.wjconstraction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainMarkAttandance extends AppCompatActivity {

    private TextView idTV;
    private TextView monthTV;
    private TextView workerdaysTV;
    private TextView absentdaysTV;

    private DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mark_attandance);

        idTV = findViewById(R.id.txtMarkWorkerID);
        monthTV = findViewById(R.id.txtMarkMonth);
        workerdaysTV = findViewById(R.id.txtMarkWorkDays);
        absentdaysTV = findViewById(R.id.txtMarkAbsentDays);

        dataHandler.openDB();
    }

    public void onMarkWorkersAT(View view){

        String id = idTV.getText().toString();
        String month = monthTV.getText().toString();
        String days = workerdaysTV.getText().toString();
        String absDay = absentdaysTV.getText().toString();

        if (id.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Worker ID can not be empty", Toast.LENGTH_LONG).show();
        } else if (month.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Month can not be empty", Toast.LENGTH_LONG).show();
        } else if (days.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Work Days can not be empty", Toast.LENGTH_LONG).show();
        } else if (absDay.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Absent Days Name can not be empty", Toast.LENGTH_LONG).show();
        } else {

            MainAttandance mainAttandance = new MainAttandance(id, month, days, absDay);
            dataHandler.markworkersattandance(mainAttandance);
            Toast.makeText(getApplicationContext(), "Attendance Mark Successfully", Toast.LENGTH_LONG).show();

            idTV.setText("");
            monthTV.setText("");
            workerdaysTV.setText("");
            absentdaysTV.setText("");

            idTV.requestFocus();
        }
    }
}