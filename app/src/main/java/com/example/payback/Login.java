package com.example.payback;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    EditText loginmyname, loginpassword;
    Button loginbtn;
    TextView newreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginbtn= findViewById(R.id.loginbtn);
        loginmyname= findViewById(R.id.loginname);
        loginpassword= findViewById(R.id.loginpassword);
        newreg= findViewById(R.id.newreg);

        newreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,MainActivity.class));
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ename=loginmyname.getText().toString().trim();
                String epassword=loginpassword.getText().toString().trim();

                if (ename.isEmpty()){
                    loginmyname.setError("Enter Your Name");
                }else if (epassword.isEmpty()){
                    loginpassword.setError("Enter Friend's Name");
                }else{
                    DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("members");
                    Query check = reference.orderByChild("myname").equalTo(ename);
                    check.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull  DataSnapshot snapshot) {
                            if (snapshot.exists()){
                                String pass = snapshot.child(ename).child("othername").getValue().toString();
                                if (pass.equals(epassword)){
                                    startActivity(new Intent(Login.this, Homepage.class));
                                }else {
                                    loginpassword.setError("Wrong Password");
                                }
                            }else {
                                Toast.makeText(Login.this, "Register Yourself", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull  DatabaseError error) {

                        }
                    });
                }
            }
        });

    }
}