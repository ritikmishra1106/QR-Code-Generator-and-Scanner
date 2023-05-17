package com.ritik.qrscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homeActivity extends AppCompatActivity {

    Button btnGen,btnScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnGen =findViewById(R.id.btnGen);
        btnScan=findViewById(R.id.btnScan);

        btnGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGen = new Intent(homeActivity.this,GenQRActivity.class);
                startActivity(intentGen);
            }
        });
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentScan = new Intent(homeActivity.this,ScanQRActivity.class);
                startActivity(intentScan);
            }
        });
    }
}