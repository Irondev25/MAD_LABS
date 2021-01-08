package com.irondev25.lab6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText fname,lname;
    TextView list;
    DBController dbController;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        list = findViewById(R.id.list);
        dbController = new DBController(this,"students",null,1);
    }

    public void btnClick(View v) {
        switch (v.getId()) {
            case R.id.addbtn:
                try {
                    dbController.insert(fname.getText().toString(),lname.getText().toString());
                }
                catch (SQLiteException e) {
                    Log.d(TAG, "addBtn: "+e.getMessage());
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.deletebtn:
                try {
                    dbController.delete(fname.getText().toString());
                }
                catch (SQLException e){
                    Log.d(TAG, "deleteBtn: "+e.getMessage());
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.updatebtn:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Enter new First Name");
                final EditText newFname = new EditText(this);
                dialog.setView(newFname);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbController.update(fname.getText().toString(),newFname.getText().toString());
                    }
                });
                dialog.show();
                break;
            case R.id.listbtn:
                dbController.list(list);
                break;
        }
    }
}