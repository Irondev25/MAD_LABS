package com.irondev25.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        printMsg("OnCreate() Called");
        Button btnFinish = findViewById(R.id.button2);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnGreen = findViewById(R.id.button1);
        btnGreen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                RelativeLayout rel = (RelativeLayout) findViewById(R.id.activity_main);
                if(flag == 1){
                    rel.setBackgroundColor(Color.WHITE);
                    flag = 0;
                }
                else{
                    rel.setBackgroundColor(Color.GREEN);
                    flag = 1;
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        printMsg("onStart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        printMsg("onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        printMsg("onDestroy() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        printMsg("onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        printMsg("onResume() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        printMsg("onRestart() called");
    }

    void printMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}