package com.example.payback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Togive extends AppCompatActivity {
    EditText togivedate, togiveamount, togivefor;
    Button togivebutton,viewgivenlistbtn;

    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_togive);
        togivedate=findViewById(R.id.togivedate);
        togiveamount=findViewById(R.id.togiveamount);
        togivefor=findViewById(R.id.togivefor);
        togivebutton=findViewById(R.id.togivebutton);
        viewgivenlistbtn=findViewById(R.id.viewgivenlistbtn);

        mydb= new DatabaseHelper(this);

        togivebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edate =togivedate.getText().toString();
                String eamount =togiveamount.getText().toString();
                String efor=togivefor.getText().toString();
                if (edate.isEmpty() || eamount.isEmpty() || efor.isEmpty()){
                    Toast.makeText(Togive.this, "Enter The Data", Toast.LENGTH_SHORT).show();
                }else {
                    boolean inserted = mydb.insertdata(edate, efor, eamount);
                    if (inserted == true) {
                        Toast.makeText(Togive.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Togive.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                    togivedate.setText("");
                    togiveamount.setText("");
                    togivefor.setText("");
                }
            }
        });

        viewgivenlistbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Togive.this,givelist.class));
            }
        });


    }
}