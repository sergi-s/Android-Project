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
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<Item> list = new ArrayList<Item>();
    List<Item> Orderd = new ArrayList<Item>();
    Context context;

    public RecycleViewAdapter(Context ct, List<Item> list) {
        this.context = ct;
        this.list = list;
    }

    public List<Item> getOrderd() {
        return Orderd;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.text1.setText(list.get(position).Name);
        holder.text2.setText(list.get(position).Description);
        holder.text3.setText(list.get(position).Price);
        holder.img.setImageResource(list.get(position).image);

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Orderd.add(list.get(position));
                Toast toast = Toast.makeText(context.getApplicationContext(), "Added Item " + position, Toast.LENGTH_SHORT);
                toast.setMargin(50, 50);
                toast.show();
            }
        });

        holder.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean deleted = false;
                for (int i = 0; i < Orderd.size(); i++) {
                    if (Orderd.get(i).image == list.get(position).image) {
                        Orderd.remove(i);
                        deleted = true;
                    }
                }
                Toast toast;
                if (deleted) {
                    toast = Toast.makeText(context.getApplicationContext(), "Deleted" + position, Toast.LENGTH_SHORT);
                } else {
                    toast = Toast.makeText(context.getApplicationContext(), "Cant Delete" + position, Toast.LENGTH_SHORT);
                }
                toast.setMargin(50, 50);
                toast.show();
                deleted = false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1, text2, text3;
        ImageView img;
        Button btn, btn2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.Item_name);
            text2 = itemView.findViewById(R.id.Item_descp);
            text3 = itemView.findViewById(R.id.Item_price);
            img = itemView.findViewById(R.id.Item_image);
            btn = itemView.findViewById(R.id.Item_add);
            btn2 = itemView.findViewById(R.id.Item_remove);
        }
    }
}
