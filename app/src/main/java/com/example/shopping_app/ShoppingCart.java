package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class ShoppingCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        Bundle bundle = getIntent().getExtras();
        List<Item> order = (List<Item>) getIntent().getExtras().getSerializable("list");

        for (int i = 0; i < order.size(); i++) {
            Log.d("Testoreder", bundle.getParcelable(String.valueOf(order.get(i))));
        }
    }
}