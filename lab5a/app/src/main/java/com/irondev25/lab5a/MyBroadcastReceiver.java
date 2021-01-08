package com.irondev25.lab5a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            Toast.makeText(context, "Power Disconnected", Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
            Toast.makeText(context, "Headset Plugged", Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            Toast.makeText(context, "Screen ON", Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Toast.makeText(context, "Screen OFF", Toast.LENGTH_SHORT).show();
        }
    }
}
