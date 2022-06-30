package com.example.wjconstraction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Add_Supervisor extends AppCompatActivity {

    private TextView id;
    private TextView name;
    private TextView nic;
    private TextView number;
    private TextView address;
    private TextView email;
    private TextView password;
    public Button delete;
    public Button update;

    DBConnector db;

    private DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supervisor);

        id = findViewById(R.id.txtUserid);
        name = findViewById(R.id.txtName);
        nic = findViewById(R.id.txtNic);
        number = findViewById(R.id.txtPhone);
        address = findViewById(R.id.txtAddress);
        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);

        delete = findViewById(R.id.DeleteSupBtn);
        update = findViewById(R.id.UpdateSupBtn);

        db = new DBConnector(this);
        dataHandler.openDB();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtUserid = id.getText().toString();
                String txtName = name.getText().toString();
                String txtNic = nic.getText().toString();
                String txtPhone = number.getText().toString();
                String txtAddress = address.getText().toString();
                String txtEmail = email.getText().toString();
                String txtPassword = password.getText().toString();

                Boolean checksupupdatetdata = db.updatesupervisordata(txtUserid, txtName, txtNic, txtPhone, txtAddress, txtEmail, txtPassword);
                if (checksupupdatetdata==true)
                    Toast.makeText(Add_Supervisor.this, "Not Updated!!!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Add_Supervisor.this, "Updated!!!", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtUserid = id.getText().toString();

                Boolean checksupdeletetdata = db.deletesupdata(txtUserid);
                if (checksupdeletetdata==true)
                    Toast.makeText(Add_Supervisor.this, "Not Deleted!!!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Add_Supervisor.this, "Deleted!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void OnClickAddSupervisor(View view) {

        String ID = id.getText().toString();
        String NAME = name.getText().toString();
        String NIC = nic.getText().toString();
        String NUMBER = number.getText().toString();
        String ADDRESS = address.getText().toString();
        String EMAIL = email.getText().toString();
        String PASSWORD = password.getText().toString();

        if (ID.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "ID can not be empty", Toast.LENGTH_LONG).show();
        } else if (NAME.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Name can not be empty", Toast.LENGTH_LONG).show();
        } else if (NIC.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Nic can not be empty", Toast.LENGTH_LONG).show();
        } else if (NUMBER.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Phone Number can not be empty", Toast.LENGTH_LONG).show();
        } else if (ADDRESS.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Address can not be empty", Toast.LENGTH_LONG).show();
        } else if (EMAIL.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Email can not be empty", Toast.LENGTH_LONG).show();
        } else if (PASSWORD.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Password can not be empty", Toast.LENGTH_LONG).show();
        } else {

            Supervisor supervisor = new Supervisor(ID, NAME, NIC, NUMBER, ADDRESS, EMAIL, PASSWORD);
            dataHandler.registerSupervisor(supervisor);
            Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_LONG).show();

            id.setText("");
            name.setText("");
            nic.setText("");
            number.setText("");
            address.setText("");
            email.setText("");
            password.setText("");

            id.requestFocus();
        }
    }
}

