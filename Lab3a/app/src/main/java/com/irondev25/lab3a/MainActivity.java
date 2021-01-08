package com.irondev25.lab3a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contacts:
                startActivity(new Intent(Intent.ACTION_DEFAULT, ContactsContract.Contacts.CONTENT_URI));
                break;
            case R.id.browser:
                Intent intent = new Intent(getApplicationContext(), BrowserActivity.class);
                startActivity(intent);
                break;
            case R.id.search:
                startActivity(new Intent(getApplicationContext(), SearchViewHandler.class));
                break;
            case R.id.map:
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=restaurants");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}