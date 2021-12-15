package com.example.payback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class Homepage extends AppCompatActivity {

    Button togive,totake;
    TextView giveamount,takeamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        togive=findViewById(R.id.togive);
        totake=findViewById(R.id.totake);
        giveamount=findViewById(R.id.giveamount);
        takeamount=findViewById(R.id.takeamount);

        togive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, Togive.class));
            }
        });

        totake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, Totake.class));
            }
        });

    }
}