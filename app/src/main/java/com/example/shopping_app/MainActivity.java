package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //TODO use shared preferences to find if loggedin or not
                Boolean isLoggedIn = true;
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
        },2000);



    }
}