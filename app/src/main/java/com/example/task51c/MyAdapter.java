package com.example.task51c;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public MyAdapter(Context c, String s1[], String s2[], int img[]) {
        context = c;
        data1 = s1;
        data2 = s2;
        images = img;
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
        holder.city_name.setText(data1[position]);
        holder.city_des.setText(data2[position]);
        holder.city_btn.setImageResource(images[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Fragment fragment;
                switch (position) {
                    case 0:  fragment = new MelbourneFragment();
                                break;
                    case 1: fragment = new SydneyFragment();
                            break;
                    case 2: fragment = new BrisbaneFragment();
                        break;
                    case 3: fragment = new PerthFragment();
                        break;
                    default: fragment = new MelbourneFragment();
                }
                //Toast.makeText(context, String.valueOf(1), Toast.LENGTH_SHORT).show();

                FragmentTransaction fragmentTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainLayout, fragment, fragment.toString()).addToBackStack(null).commit();
            }
        });
    }


    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView city_name, city_des;
        ImageView city_btn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            city_name = itemView.findViewById(R.id.city_name);
            city_des = itemView.findViewById(R.id.city_des);
            city_btn = itemView.findViewById(R.id.city_btn);

        }
    }
}