package com.example.wjconstraction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Add_Workers extends AppCompatActivity {

    private TextView id;
    private TextView name;
    private TextView nic;
    private TextView phone;
    private TextView address;
    public Button delete;
    public Button update;

    DBConnector db;

    private DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workers);

        id = findViewById(R.id.txtWorkerId);
        name = findViewById(R.id.txtWorkerName);
        nic = findViewById(R.id.txtWorkerNic);
        phone = findViewById(R.id.txtWorkerNum);
        address = findViewById(R.id.txtWorkerAddress);

        delete = findViewById(R.id.DeleteWorkerBtn);
        update = findViewById(R.id.UpdateWorkerBtn);

        db = new DBConnector(this);
        dataHandler.openDB();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtWorkerId = id.getText().toString();
                String txtWorkerName = name.getText().toString();
                String txtWorkerNic = nic.getText().toString();
                String txtWorkerNum = phone.getText().toString();
                String txtWorkerAddress = address.getText().toString();

                Boolean checkupdatetdata = db.updateworkerdata(txtWorkerId, txtWorkerName, txtWorkerNic, txtWorkerNum, txtWorkerAddress);
                if (checkupdatetdata==true)
                    Toast.makeText(Add_Workers.this, "Not Updated!!!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Add_Workers.this, "Updated!!!", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtWorkerId = id.getText().toString();

                Boolean checkdeletetdata = db.deletedata(txtWorkerId);
                if (checkdeletetdata==true)
                    Toast.makeText(Add_Workers.this, "Not Deleted!!!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Add_Workers.this, "Deleted!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void OnClickAddWorker(View view) {
        String WORKERID = id.getText().toString();
        String NAME = name.getText().toString();
        String NIC = nic.getText().toString();
        String PHONE = phone.getText().toString();
        String ADDRESS = address.getText().toString();

        if (WORKERID.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "ID can not be empty", Toast.LENGTH_LONG).show();
        }else if (NAME.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Name can not be empty", Toast.LENGTH_LONG).show();
        }else if (NIC.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Nic can not be empty", Toast.LENGTH_LONG).show();
        }else if (PHONE.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Phone Number can not be empty", Toast.LENGTH_LONG).show();
        }else if (ADDRESS.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Address can not be empty", Toast.LENGTH_LONG).show();
        }else {

            Worker worker = new Worker(WORKERID, NAME, NIC, PHONE, ADDRESS);
            dataHandler.addWorker(worker);
            Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_LONG).show();

            id.setText("");
            name.setText("");
            nic.setText("");
            phone.setText("");
            address.setText("");

            id.requestFocus();
        }
    }
}