package com.irondev25.lab4b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private static final int t1=1,t2=2,t3=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.msg_panel);
        button = findViewById(R.id.start_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData(v);
            }
        });
    }

    public void fetchData(View v) {
        textView.setText("Main Thread");
        th1.start();
        th2.start();
        th3.start();
    }

    Thread th1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=0; i<5; i++) {
                try {
                    Thread.sleep(1000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(t1);
            }
        }
    });

    Thread th2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=0; i<5; i++) {
                try {
                    Thread.sleep(2000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(t2);
            }
        }
    });

    Thread th3 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=0; i<5; i++) {
                try {
                    Thread.sleep(3000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(t3);
            }
        }
    });

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if(msg.what == t1) {
                textView.append("\nIn Thread1");
            }
            if(msg.what == t2) {
                textView.append("\nIn Thread2");
            }
            if(msg.what == t3) {
                textView.append("\nIn Thread3");
            }
        }
    };
}