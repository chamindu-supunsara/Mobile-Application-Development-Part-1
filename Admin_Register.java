package com.example.wjconstraction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin_Register extends AppCompatActivity {

    private TextView id;
    private TextView name;
    private TextView nic;
    private TextView number;
    private TextView address;
    private TextView email;
    private TextView password;

    private DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

        id = findViewById(R.id.txtUserid);
        name = findViewById(R.id.txtName);
        nic = findViewById(R.id.txtNic);
        number = findViewById(R.id.txtPhone);
        address = findViewById(R.id.txtAddress);
        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);

        dataHandler.openDB();
    }

    public void OnClickAdminRegister(View view) {

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

            Admin admin = new Admin(ID, NAME, NIC, NUMBER, ADDRESS, EMAIL, PASSWORD);
            dataHandler.registerAdmin(admin);
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