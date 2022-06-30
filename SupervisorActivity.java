package com.example.wjconstraction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SupervisorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor);
    }

    public void OnClickManageWorkers(View view){
        Intent intent = new Intent(this, Add_Workers.class);
        startActivity(intent);
    }

    public void OnClickMarkAttendance(View view){
        Intent intent = new Intent(this, MainMarkAttandance.class);
        startActivity(intent);
    }

    public void OnClickCalSalary(View view){
        Intent intent = new Intent(this, CalSalary.class);
        startActivity(intent);
    }
}