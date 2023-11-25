package com.example.appreadingbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.load.model.Model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class IntroductionUserActivity extends AppCompatActivity {

    ImageButton IB_back;
    Button bt_docSach,bt_home,bt_profile,bt_category,bt_thanhToan;
    TextView tvBookTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_user);

        IB_back = (ImageButton) findViewById(R.id.imageButton);
        bt_docSach = (Button) findViewById(R.id.bt_docSach);
        bt_home = (Button) findViewById(R.id.bt_home);
        bt_profile = (Button) findViewById(R.id.bt_profile);
        bt_category = (Button) findViewById(R.id.bt_category);
        bt_thanhToan = (Button) findViewById(R.id.bt_thanhToanh);
        tvBookTitle = findViewById(R.id.title);



        IB_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionUserActivity.this, HomeUserActivity.class);
                startActivity(intent);
            }
        });
        bt_docSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionUserActivity.this, BookUserActivity.class);
                startActivity(intent);
            }
        });
        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionUserActivity.this, HomeUserActivity.class);
                startActivity(intent);
            }
        });
        bt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionUserActivity.this, ProfileUserActivity.class);
                startActivity(intent);
            }
        });
        bt_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionUserActivity.this, CategoryUserActivity.class);
                startActivity(intent);
            }
        });
        bt_thanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionUserActivity.this, PayActivity.class);
                startActivity(intent);
            }
        });



        FirebaseRecyclerOptions<HomeModel> options =
                new FirebaseRecyclerOptions.Builder<HomeModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("books"), HomeModel.class)
                        .build();




        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Model model=  (Model )bundle.getSerializable("model");


    }
}