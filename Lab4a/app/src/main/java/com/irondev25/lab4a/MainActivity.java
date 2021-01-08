package com.irondev25.lab4a;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.prompt_dialog,null);
                EditText editText = view.findViewById(R.id.stu_id);
                AlertDialog.Builder builder = new
                        AlertDialog.Builder(MainActivity.this)
                        .setView(view).setPositiveButton("Display", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String x = editText.getText().toString();
                                if(x.equals("IS063")) {
                                    Toast.makeText(MainActivity.this, "Name: Rahul Bhaskar\nUSN:1BM17IS063", Toast.LENGTH_SHORT).show();
                                }
                                else{   
                                    Toast.makeText(MainActivity.this, "Student Not Found", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("Help", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Enter Student USN to find details", Toast.LENGTH_SHORT).show();
                            }
                        }).setCancelable(true);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}