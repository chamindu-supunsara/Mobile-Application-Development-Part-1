package com.example.wjconstraction;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FindSupervisors extends AppCompatActivity {

    public TextView id;
    public TextView name;
    public TextView nic;
    public TextView number;
    public TextView address;
    public TextView email;
    public TextView password;
    public Button view;

    DBConnector db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_supervisors);

        id = findViewById(R.id.txtUserid);
        name = findViewById(R.id.txtName);
        nic = findViewById(R.id.txtNic);
        number = findViewById(R.id.txtPhone);
        address = findViewById(R.id.txtAddress);
        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);

        view = findViewById(R.id.BtnViewSup);

        db = new DBConnector(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getsup();
                if (res.getCount() == 0){
                    Toast.makeText(FindSupervisors.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("ID : "+res.getString(0)+"\n");
                        buffer.append("NAME : "+res.getString(1)+"\n");
                        buffer.append("NIC : "+res.getString(2)+"\n");
                        buffer.append("NUMBER : "+res.getString(3)+"\n");
                        buffer.append("ADDRESS : "+res.getString(4)+"\n");
                        buffer.append("EMAIL : "+res.getString(5)+"\n");
                        buffer.append("PASSWORD : "+res.getString(6)+"\n\n");
                    }

                AlertDialog.Builder builder = new AlertDialog.Builder(FindSupervisors.this);
                builder.setCancelable(true);
                builder.setTitle("ALL SUPERVISORS");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}