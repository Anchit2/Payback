package com.example.payback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Totake extends AppCompatActivity {

    EditText totakedate, totakeamount, totakefor;
    Button totakebutton, viewtakenlistbtn;

    DatabaseHelperToTake mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totake);
        totakedate=findViewById(R.id.totakedate);
        totakeamount=findViewById(R.id.totakeamount);
        totakefor=findViewById(R.id.totakefor);
        totakebutton=findViewById(R.id.totakebutton);
        viewtakenlistbtn=findViewById(R.id. viewtakenlistbtn);

        mydb= new DatabaseHelperToTake(this);

        totakebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edate =totakedate.getText().toString();
                String eamount =totakeamount.getText().toString();
                String efor=totakefor.getText().toString();
                if (edate.isEmpty() || eamount.isEmpty() || efor.isEmpty()){
                    Toast.makeText(Totake.this, "Enter The Data", Toast.LENGTH_SHORT).show();
                }else {
                    boolean inserted = mydb.insertdata(edate, efor, eamount);
                    if (inserted == true) {
                        Toast.makeText(Totake.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Totake.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                    totakedate.setText("");
                    totakeamount.setText("");
                    totakefor.setText("");
                }
            }
        });

        viewtakenlistbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Totake.this,take_list.class));
            }
        });
    }
}