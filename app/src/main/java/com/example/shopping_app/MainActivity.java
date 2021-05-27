package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Boolean isLoggedIn = !(loadData()).equals("");

                if (isLoggedIn) {
                    Intent i = new Intent(MainActivity.this, ShoppingList.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(MainActivity.this, registration.class);
                    startActivity(i);
                    finish();
                }


            }
        }, 2000);


    }

    public String loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String usname = sharedPreferences.getString(USERNAME, "");
        return usname;
    }
}