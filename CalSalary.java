package com.example.wjconstraction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CalSalary extends AppCompatActivity {

    private ArrayList<String> id = new ArrayList<String>();
    private ArrayList<String> spayment = new ArrayList<String>();
    private ArrayList<String> day = new ArrayList<String>();
    private ArrayList<String> amount = new ArrayList<String>();

    private TableLayout tblSalary;
    private TextView txtSalaryWorkerID;
    private TextView txtPayment;
    private TextView txtWorkDays;
    private TextView txtAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_salary);

        txtSalaryWorkerID = findViewById(R.id.txtSalaryWorkerID);
        txtPayment = findViewById(R.id.txtPayment);
        txtWorkDays = findViewById(R.id.txtWorkDays);
        txtAmount = findViewById(R.id.txtAmount);
    }

    public void OnClickCalculateSalary(View view){

        int tot;
        String wid = txtSalaryWorkerID.getText().toString();
        int payment = Integer.parseInt(txtPayment.getText().toString());
        int workerdays = Integer.parseInt(txtWorkDays.getText().toString());
        tot = payment * workerdays;

        id.add(wid);
        spayment.add(String.valueOf(payment));
        day.add(String.valueOf(workerdays));
        amount.add(String.valueOf(tot));

        TableLayout table = (TableLayout)findViewById(R.id.tblSalary);

        TableRow tableRow = new TableRow(this);
        TextView tv1 = new TextView(this);
        TextView tv2 = new TextView(this);
        TextView tv3 = new TextView(this);
        TextView tv4 = new TextView(this);

        String total;

        int sum = 0;

        for (int i = 0; i<id.size(); i++){
            String Wid = id.get(i);
            String pay = spayment.get(i);
            String Dy = day.get(i);

            total = amount.get(i);

            tv1.setText(Wid);
            tv2.setText(pay);
            tv3.setText(Dy);
            tv4.setText(total);

            sum = sum + Integer.parseInt(amount.get(i).toString());
        }
        tableRow.addView(tv1);
        tableRow.addView(tv2);
        tableRow.addView(tv3);
        tableRow.addView(tv4);

        table.addView(tableRow);

        txtAmount.setText(String.valueOf(sum));
        txtSalaryWorkerID.setText("");
        txtWorkDays.setText("");
        txtSalaryWorkerID.requestFocus();
    }
}