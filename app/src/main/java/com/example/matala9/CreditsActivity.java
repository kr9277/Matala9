package com.example.matala9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CreditsActivity extends AppCompatActivity {
    Button btn;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        btn = findViewById(R.id.btn);
        tv2 = findViewById(R.id.tv2);
        Intent intent = getIntent();
        double result = intent.getDoubleExtra("result", 0.0);
        Toast.makeText(this, ""+result, Toast.LENGTH_SHORT).show();
        tv2.setText(String.valueOf(result));
    }

    public void click(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}