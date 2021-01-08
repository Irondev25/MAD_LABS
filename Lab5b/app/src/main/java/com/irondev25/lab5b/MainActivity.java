package com.irondev25.lab5b;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button fetchButton, postButton;
    public TextView dataView;
    public ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);

        fetchButton = findViewById(R.id.parse);
        postButton = findViewById(R.id.post);
        dataView = findViewById(R.id.response);
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchData x = new FetchData(MainActivity.this);
                x.execute();
            }
        });
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostData x = new PostData(MainActivity.this);
                x.execute();
            }
        });
    }
}