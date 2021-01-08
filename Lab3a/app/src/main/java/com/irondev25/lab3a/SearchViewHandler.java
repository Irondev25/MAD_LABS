package com.irondev25.lab3a;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;

public class SearchViewHandler extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        searchView = findViewById(R.id.search_view);
        listView = findViewById(R.id.lv1);
        listView.setVisibility(View.INVISIBLE);

        list = new ArrayList<>();

        list.add("apple");
        list.add("banana");
        list.add("pineapple");
        list.add("ornage");
        list.add("Guava");
        list.add("Peech");
        list.add("Melon");
        list.add("Watermelon");
        list.add("Papaya");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(list.contains(query)){
                    listView.setVisibility(View.VISIBLE);
                    adapter.getFilter().filter(query);
                }
                else {
                    Toast.makeText(SearchViewHandler.this, "No Match", Toast.LENGTH_LONG).show();
                    listView.setVisibility(View.INVISIBLE);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}
