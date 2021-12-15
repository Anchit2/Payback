package com.example.payback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText regmyname, password;
    Button regbtn;
    TextView aldyreg;
    FirebaseDatabase database;
    DatabaseReference reference;
    DatabaseHelper helper;
    ArrayList<Listvalues> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regmyname=findViewById(R.id.loginname);
        password=findViewById(R.id.loginpassword);
        regbtn=findViewById(R.id.loginbtn);
        aldyreg=findViewById(R.id.aldyreg);
        helper= new DatabaseHelper(this);
        arrayList= new ArrayList<>();

        aldyreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Login.class));
            }
        });


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emyname= regmyname.getText().toString();
                String eothername= password.getText().toString();

                database= FirebaseDatabase.getInstance();

                if (emyname.isEmpty()){
                    regmyname.setError("Enter Your Name");
                }else if (eothername.isEmpty()){
                    password.setError("Set Password");
                }else {
                    regmyname.setError(null);
                    password.setError(null);
                    usersdetails user = new usersdetails(emyname, eothername);
                    reference = database.getReference().child("members");
                    reference.child(emyname).setValue(user);
                    startActivity(new Intent(MainActivity.this, Login.class));

                }

            }
        });


    }
}