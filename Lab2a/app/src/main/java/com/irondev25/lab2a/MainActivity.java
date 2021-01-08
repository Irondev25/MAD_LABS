package com.irondev25.lab2a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Spinner c;
    TextView  t;
    HashMap x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x = new HashMap();
        x.put("Hello","Bonjour");
        x. put ("Goodbye", "Au Revoir");
        x.put("Good Evening", "Bonsoir");
        x.put("Good Night", "Bonne nuit");
        x.put("Please","S'il vous plaY@t");
        x.put("Thank you", "Merci"); x.put("Sorry", "Pardon");
        x.put ("It's okay", "Ata va"); x.put ("It's good", "C'est bien");
        x.put("We", "Nous");
        x.put("You", "Vous");
        x.put ("Mr.", "Monsieur");
        x.put ("Miss", "Mademoiselle");
        x.put("Red", "Rouge");
        x.put("Black", "Noir");
        x.put ("Blue", "Bleu");
        x.put("Yellow", "Jaune");
        x.put ("Bread", "Pain");
        x.put("Wine", "Du vin");
        x.put ("Chicken", "poulet");
        x.put ("Rice", "Riz");
        ArrayList<String> words = new ArrayList<>();
        for(Object key: x.keySet()){
            words.add(key.toString());
        }
        c = (Spinner)findViewById(R.id.ch);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,words);
        c.setAdapter(adapter);
        t = (TextView) findViewById(R.id.text);
        Button b = (Button) findViewById(R.id.translate);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = c.getSelectedItem().toString();
                if(x.containsKey(a)){
                    t.setText(x.get(a).toString());
                }
            }
        });
    }
}