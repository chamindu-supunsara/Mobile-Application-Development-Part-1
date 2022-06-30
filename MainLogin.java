package com.example.wjconstraction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainLogin extends AppCompatActivity {

    private TextView id;
    private TextView password;

    private DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        id = (TextView)findViewById(R.id.txtLoginUserId);
        password = (TextView)findViewById(R.id.txtLoginPassword);

        dataHandler.openDB();
    }

    public void OnClickLogin(View view){

        String ID = id.getText().toString();
        String PASSWORD = password.getText().toString();

            Boolean checkForID = dataHandler.checkForID(ID, PASSWORD);
            if (checkForID == true) {
                Toast.makeText(getApplicationContext(), "Logging Successfully!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

            } else {

                Boolean checkForSupID = dataHandler.checkForSupID(ID, PASSWORD);
                if (checkForSupID == true) {
                    Toast.makeText(getApplicationContext(), "Logging Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, SupervisorActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Logging Failed.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}