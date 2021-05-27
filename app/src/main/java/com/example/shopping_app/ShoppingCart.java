package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends AppCompatActivity {
    RecyclerView recycleView;
    List<Item> order;
    double sum = 0;
    TextView totalprice;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        Intent intent = getIntent();
        order = (List<Item>) intent.getSerializableExtra("List");
        btn = findViewById(R.id.button);
        recycleView = findViewById(R.id.shoppingCartView);

        RecycleViewAdapterCart myAdapter = new RecycleViewAdapterCart(this, order);

        recycleView.setAdapter(myAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));


        for (int i = 0; i < order.size(); i++) {
            String str = order.get(i).Price;
            StringBuilder sb = new StringBuilder(str);
            sum += Double.parseDouble(sb.deleteCharAt(str.length() - 1).toString());
        }

        totalprice = (TextView) findViewById(R.id.totalprice);
        totalprice.setText( "Total Price "+String.valueOf(sum));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("total", sum);

                intent.setAction("com.example.shopping_app.CUSTOM_INTENT");
                sendBroadcast(intent);


            }
        });
    }

    public void broadcastIntent(View view) {

    }

}