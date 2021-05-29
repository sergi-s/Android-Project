package com.example.shopping_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("gg", "onReceive: ");
        String total="Total price for items "+intent.getDoubleExtra("total",0);
        Toast.makeText(context, total, Toast.LENGTH_LONG).show();

    }
}