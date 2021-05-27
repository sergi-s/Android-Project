package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.ShareCompat;
import androidx.core.app.ShareCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My notification", "My notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

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
        totalprice.setText("Total Price " + String.valueOf(sum));

        Mynotify(String.valueOf(sum));


    }
    public void shareText(View view) {

        String txt ="";
        for (int i=0;i<order.size();i++){
            txt+=order.get(i).toString();
        }
        txt+=" Total Price " + String.valueOf(sum);
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("R.string.share_text_with")
                .setText(txt)
                .startChooser();
        Log.d("sssss","ssssssss");
    }

    public void Mynotify(String s) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "My notification");
        builder.setContentTitle("Order In your way");
        builder.setContentText("Your Total is " + s + "\tThanks for using our app");
        builder.setSmallIcon(R.drawable.shopping_cart);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
        managerCompat.notify(1, builder.build());
    }
}
