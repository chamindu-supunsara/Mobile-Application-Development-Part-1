package com.example.wjconstraction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickViewSupervisor(View view){
        Intent intent = new Intent(this, FindSupervisors.class);
        startActivity(intent);
    }

    public void OnClickViewWorkers(View view){
        Intent intent = new Intent(this, ViewWorkers.class);
        startActivity(intent);
    }

    public void OnClickAdminRegister(View view){
        Intent intent = new Intent(this, Admin_Register.class);
        startActivity(intent);
    }

    public void OnClickAddConSite(View view){
        Intent intent = new Intent(this, Add_ConSite.class);
        startActivity(intent);
    }

    public void OnClickAddSupervisors(View view){
        Intent intent = new Intent(this, Add_Supervisor.class);
        startActivity(intent);
    }

    public void OnClickAddWorkers(View view){
        Intent intent = new Intent(this, Add_Workers.class);
        startActivity(intent);
    }
}