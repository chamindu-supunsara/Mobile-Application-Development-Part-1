package com.example.wjconstraction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Add_ConSite extends AppCompatActivity {

    private TextView id;
    private TextView name;
    private TextView location;
    private TextView supervisor;

    private DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_con_site);

        id = findViewById(R.id.txtWorkerId);
        name = findViewById(R.id.txtWorkerName);
        location = findViewById(R.id.txtWorkerNic);
        supervisor = findViewById(R.id.txtSupName);

        dataHandler.openDB();
    }

    public void OnClickContractionSite(View view) {
        String SITEID = id.getText().toString();
        String SITENAME = name.getText().toString();
        String LOCATION = location.getText().toString();
        String SUPERVISORNAME = supervisor.getText().toString();

        if (SITEID.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Site ID can not be empty", Toast.LENGTH_LONG).show();
        } else if (SITENAME.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Site Name can not be empty", Toast.LENGTH_LONG).show();
        } else if (LOCATION.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Location can not be empty", Toast.LENGTH_LONG).show();
        } else if (SUPERVISORNAME.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Supervisor Name can not be empty", Toast.LENGTH_LONG).show();
        } else {

            ContractionSite contractionSite = new ContractionSite(SITEID, SITENAME, LOCATION, SUPERVISORNAME);
            dataHandler.addContractionSite(contractionSite);
            Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_LONG).show();

            id.setText("");
            name.setText("");
            location.setText("");
            supervisor.setText("");

            id.requestFocus();
        }
    }
}