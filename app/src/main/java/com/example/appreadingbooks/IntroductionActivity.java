package com.example.appreadingbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class IntroductionActivity extends AppCompatActivity {

    ImageButton IB_back;
    Button bt_docSach,bt_home,bt_profile,bt_category,bt_sua;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        IB_back = (ImageButton) findViewById(R.id.imageButton);
        bt_docSach = (Button) findViewById(R.id.bt_docSach);
        bt_home = (Button) findViewById(R.id.bt_home);
        bt_profile = (Button) findViewById(R.id.bt_profile);
        bt_category = (Button) findViewById(R.id.bt_category);
        bt_sua = (Button) findViewById(R.id.bt_sua);


        IB_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        bt_docSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionActivity.this, BookActivity.class);
                startActivity(intent);
            }
        });
        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        bt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        bt_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
        bt_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionActivity.this, UpdateActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        HomeModel model=  (HomeModel )bundle.getSerializable("homeModel");
        Log.e("zzzzzzzzzzzz",model.author.toString());






    }
}