package com.example.wjconstraction;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewWorkers extends AppCompatActivity {

    private TextView id;
    private TextView name;
    private TextView nic;
    private TextView phone;
    private TextView address;
    public Button view;

    DBConnector db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workers);

        id = findViewById(R.id.txtWorkerId);
        name = findViewById(R.id.txtWorkerName);
        nic = findViewById(R.id.txtWorkerNic);
        phone = findViewById(R.id.txtWorkerNum);
        address = findViewById(R.id.txtWorkerAddress);

        view = findViewById(R.id.ViewWorkerBtn);

        db = new DBConnector(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getdata();
                if (res.getCount() == 0){
                    Toast.makeText(ViewWorkers.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
            }
            StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("WORKERID : "+res.getString(0)+"\n");
                    buffer.append("NAME : "+res.getString(1)+"\n");
                    buffer.append("NIC : "+res.getString(2)+"\n");
                    buffer.append("PHONE : "+res.getString(3)+"\n");
                    buffer.append("ADDRESS : "+res.getString(4)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(ViewWorkers.this);
                builder.setCancelable(true);
                builder.setTitle("ALL MASONRY WORKERS");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}