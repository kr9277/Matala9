package com.example.matala9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    EditText et1;
    int num1 = 0;
    int num2 = 0;
    double result = 0.0;
    int which = 0;
    int shave_click = 0;
    boolean bool1 = false;
    boolean bool2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
    }

    public void kefel(View view) {
        if (which!=0){
            Toast.makeText(this, "You can not do it, you can only make one operation", Toast.LENGTH_SHORT).show();
            delete(view);
        }
        else {
            which = 3;
            num1 = Integer.parseInt(et1.getText().toString());
            et1.setText("");
            bool1 = true;
        }
    }

    public void plus(View view) {
        if (which!=0){
            Toast.makeText(this, "You can not do it, you can only make one operation", Toast.LENGTH_SHORT).show();
            delete(view);
        }
        else {
            which = 1;
            num1 = Integer.parseInt(et1.getText().toString());
            et1.setText("");
            bool1 = true;
        }
    }

    public void delete(View view) {
        num1 = 0;
        num2 = 0;
        which = 0;
        et1.setText("");
        bool1 = false;
        bool2 = false;
    }

    public void minus(View view) {
        if (which!=0){
            Toast.makeText(this, "You can not do it, you can only make one operation", Toast.LENGTH_SHORT).show();
            delete(view);
        }
        else {
            which = 2;
            num1 = Integer.parseInt(et1.getText().toString());
            et1.setText("");
            bool1 = true;
        }
    }

    public void divide(View view) {
        if (which!=0){
            Toast.makeText(this, "You can not do it, you can only make one operation", Toast.LENGTH_SHORT).show();
            delete(view);
        }
        else {
            which = 4;
            num1 = Integer.parseInt(et1.getText().toString());
            et1.setText("");
            bool1 = true;
        }
    }

    public void Shave(View view) {
        num2 = Integer.parseInt(et1.getText().toString());
        bool2 = true;
        shave_click = 1;
        if (which!=0 && bool1 == true && bool2 == true){
            if (which==4 && num2 == 0){
                Toast.makeText(this, "Math Eror", Toast.LENGTH_SHORT).show();
                delete(view);
            }
            else {
                if (which==1){
                    result = num1 + num2;
                }
                if (which==2){
                    result = num1 - num2;
                }
                if (which==3){
                    result = num1 * num2;
                }
                if (which==4){
                    double num = (double) num1;
                    result = num / num2;
                }
            }
        }
        else {
            Toast.makeText(this, "You did not enter all the numbers", Toast.LENGTH_SHORT).show();
            delete(view);
        }
    }

    public void credit(View view) {
        if (shave_click == 0){
            Toast.makeText(this, "You did not clicked on this: '=' button", Toast.LENGTH_SHORT).show();
            delete(view);
        }
        Intent intent = new Intent(this, CreditsActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}