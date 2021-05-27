package com.example.shopping_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapterCart extends RecyclerView.Adapter<RecycleViewAdapterCart.MyViewHolderTwo> {

    List<Item> list = new ArrayList<Item>();
    List<Item> Orderd = new ArrayList<Item>();
    Context context;

    public RecycleViewAdapterCart(Context ct, List<Item> list) {
        this.context = ct;
        this.list = list;
    }

    public List<Item> getOrderd() {
        return Orderd;
    }

    @NonNull
    @Override
    public MyViewHolderTwo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.your_row, parent, false);

        return new MyViewHolderTwo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapterCart.MyViewHolderTwo holder, int position) {

        holder.text1.setText(list.get(position).Name);
        holder.text2.setText(list.get(position).Description);
        holder.text3.setText(list.get(position).Price);
        holder.img.setImageResource(list.get(position).image);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolderTwo extends RecyclerView.ViewHolder {
        TextView text1, text2, text3;
        ImageView img;

        ConstraintLayout mainLayout;

        public MyViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.Item_name);
            text2 = itemView.findViewById(R.id.Item_descp);
            text3 = itemView.findViewById(R.id.Item_price);
            img = itemView.findViewById(R.id.Item_image);

        }
    }
}
