package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class ShoppingCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        Intent intent = getIntent();
        List<Item> order = (List<Item>) intent.getSerializableExtra("List");


        double sum = 0;
        for (int i = 0; i < order.size(); i++) {
            String str = order.get(i).Price;
            StringBuilder sb = new StringBuilder(str);
            sum += Integer.parseInt(sb.deleteCharAt(str.length() - 1).toString());
        }

        Log.d("Total Price", String.valueOf(sum));
    }
}