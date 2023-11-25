package com.example.appreadingbooks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {

    ImageButton IB_sach;
    Button bt_profile,bt_category,bt_them;
//======================Uyen==============================
    RecyclerView recyclerView;
    HomeAdapter homeAdapter;

//===================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        =======================Uyen============================
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<HomeModel> options =
                new FirebaseRecyclerOptions.Builder<HomeModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("books"), HomeModel.class)
                        .build();

        homeAdapter = new HomeAdapter(options, homeModel -> {
        Bundle bundle = new Bundle();
        bundle.putSerializable("homeModel",homeModel);
        Intent intent = new Intent(HomeActivity.this,IntroductionActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        });
        recyclerView.setAdapter(homeAdapter);

        bt_them = (Button) findViewById(R.id.buttonadd);
        bt_category = (Button) findViewById(R.id.bt_category);
        bt_profile = (Button) findViewById(R.id.bt_profile);

        bt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        bt_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
        bt_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, InsertActivity.class);
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