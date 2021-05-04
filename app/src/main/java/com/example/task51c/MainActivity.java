package com.example.task51c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    RecyclerView recyclerView;

    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    String s1[], s2[];
    int images[] = {R.drawable.melbourne, R.drawable.perth, R.drawable.brisbane, R.drawable.sydney};
    ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        int images[] = {R.drawable.melbourne, R.drawable.perth, R.drawable.brisbane, R.drawable.sydney};
        String[] cityName = {"Melbourne", "Perth", "Brisbane", "Sydney"};

        mainModels = new ArrayList<>();
        for (int i=0; i<images.length; i++) {
            MainModel model = new MainModel(images[i], cityName[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mainAdapter = new MainAdapter(MainActivity.this, mainModels);
        recyclerView.setAdapter(mainAdapter);

        mainLayout = findViewById(R.id.mainLayout);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.city_name);
        s2 = getResources().getStringArray(R.array.city_description);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}