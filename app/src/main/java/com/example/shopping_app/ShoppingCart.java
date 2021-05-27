package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class ShoppingCart extends AppCompatActivity {

    List<Item> order;
    double sum = 0;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        btn=findViewById(R.id.button);
        Intent intent = getIntent();
        order = (List<Item>) intent.getSerializableExtra("List");

//        for (int i = 0; i < order.size(); i++) {
//            Log.d("Ordred", String.valueOf(order.get(0)));
//        }

        for (int i = 0; i < order.size(); i++) {
            String str = order.get(i).Price;
            StringBuilder sb = new StringBuilder(str);
            sum += Double.parseDouble(sb.deleteCharAt(str.length() - 1).toString());
        }

        Log.d("Total Price", String.valueOf(sum));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("total",sum);

                intent.setAction("com.example.shopping_app.CUSTOM_INTENT");
                sendBroadcast(intent);
                Log.d("aaaaaaaaaaaaaaaaaaaaaaa", "broadcastIntent: ");
            }
        });
    }

    public void broadcastIntent(View view){

    }

}