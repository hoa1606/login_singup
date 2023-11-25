package com.example.appreadingbooks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class HomeUserActivity extends AppCompatActivity {


    Button bt_profile;
    Button bt_category;
    RecyclerView recyclerView;
    HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<HomeModel> options =
                new FirebaseRecyclerOptions.Builder<HomeModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("books"), HomeModel.class)
                        .build();

        homeAdapter = new HomeAdapter(options, homeModel -> {

        });
        recyclerView.setAdapter(homeAdapter);

        //IB_sach = (ImageButton) findViewById(R.id.IB_typhubangiay);
        bt_profile = (Button) findViewById(R.id.bt_profile);
        bt_category = (Button) findViewById(R.id.bt_category);



        bt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeUserActivity.this, ProfileUserActivity.class);
                startActivity(intent);
            }
        });
        bt_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeUserActivity.this, CategoryUserActivity.class);
                startActivity(intent);
            }
        });



    }

    protected void onStart(){
        super.onStart();
        homeAdapter.startListening();
    }

    protected void onStop(){
        super.onStop();
        homeAdapter.stopListening();
    }
}