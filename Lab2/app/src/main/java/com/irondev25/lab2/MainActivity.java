package com.irondev25.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText cie1,cie2,cie3,aat;
    TextView result;
    Button btnGetResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cie1 = findViewById(R.id.cie1);
        cie2 = findViewById(R.id.cie2);
        cie3 = findViewById(R.id.cie3);
        aat = findViewById(R.id.aat);
        result = findViewById(R.id.result);
        btnGetResult = findViewById(R.id.getMarks);
        btnGetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFinalMarks();
            }
        });
    }

    private void displayFinalMarks() {
        String c1 = cie1.getText().toString();
        String c2 = cie2.getText().toString();
        String c3 = cie3.getText().toString();
        String a = aat.getText().toString();

        if(c1.equals(""))
            printMsg("Please Enter CIE-1  marks");
        else if(c2.equals(""))
            printMsg("Please Enter CIE-2 marks");
        else if(c3.equals(""))
            printMsg("Please Enter CIE-3 marks");
        else if(a.equals(""))
            printMsg("Please Enter AAT marks");
        else{
            int c11 = Integer.parseInt(c1);
            int c22 = Integer.parseInt(c2);
            int c33 = Integer.parseInt(c3);
            int aa = Integer.parseInt(a);
            int max = Math.max(c11,c22);
            int min = Math.min(c11,c22);
            int res = Math.max(max,c33) + Math.max(min,c33);
            res += aa;
            result.setText(res+"");
            if(res<20){
                result.setTextColor(Color.RED);
            }
            else{
                result.setTextColor(Color.GREEN);
            }
        }
    }

    private void printMsg(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}