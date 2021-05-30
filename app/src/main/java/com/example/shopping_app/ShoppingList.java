package com.example.shopping_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends AppCompatActivity {

    Button toShoppingCart;
    RecyclerView recycleView;


    List<Item> list = new ArrayList<Item>();
    String str1[], str2[];
    String str3[] = {"50$", "60$", "70$", "80$", "100$", "80$", "95$"};
    int images[] = {R.drawable.knee_pads, R.drawable.helmet, R.drawable.pants, R.drawable.bicycles, R.drawable.bottles, R.drawable.shirts, R.drawable.nikes};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        recycleView = findViewById(R.id.recycleView);
        getSupportActionBar().setTitle("Habdology");
        str1 = getResources().getStringArray(R.array.shopping_items);
        str2 = getResources().getStringArray(R.array.description);

        for (int i = 0; i < str1.length; i++) {
            list.add(new Item(str1[i], str2[i], str3[i], images[i]));
        }

        RecycleViewAdapter myAdapter = new RecycleViewAdapter(this, list);

        recycleView.setAdapter(myAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));

        toShoppingCart = findViewById(R.id.toShoppingCart);

        toShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Item> order = myAdapter.getOrderd();
//                for (int i = 0; i < order.size(); i++) {
//                    Log.d("Testoreder", String.valueOf((order.get(i))));
//                }
                Intent i = new Intent(ShoppingList.this, ShoppingCart.class);
//                Bundle bundle = new Bundle();
//                bundle.putParcelable("data", (Parcelable) order);
                i.putExtra("List", (Serializable) order);
                startActivity(i);
//                i.putExtra("order", (Serializable) order);
//                startActivity(i);
//                finish();
            }
        });
    }
}