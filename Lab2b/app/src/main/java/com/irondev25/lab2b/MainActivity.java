package com.irondev25.lab2b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ArrayList<Item> items;
    Button getTotal;
    TextView result;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        items.add(new Item("Rice",20));
        items.add(new Item("Milk",25));
        items.add(new Item("Bread",15));
        items.add(new Item("Egg",5));

        getTotal=findViewById(R.id.button);
        result=findViewById(R.id.result);
        lv=findViewById(R.id.lv);
        CustomAdapter adapter = new CustomAdapter(this,items);
        lv.setAdapter(adapter);
        getTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = 0;
                for(Item item:items){
                    total += item.getPrice()*item.getQuantity();
                }
                result.setText("Total: "+total);
            }
        });
    }
}