package com.example.qrcodenew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvHasil = findViewById(R.id.tv_hasil);

        String result = getIntent().getStringExtra("result");

        tvHasil.setText(result);



    }
}