package com.example.appreadingbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileUserActivity extends AppCompatActivity {

    Button bt_home;
    Button bt_category;
    TextView tv_dangXuat;

    FirebaseAuth auth;
    FirebaseUser user;
    TextView tvnameadmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);

        bt_home = (Button) findViewById(R.id.bt_home);
        bt_category = (Button) findViewById(R.id.bt_category);
        tv_dangXuat = (TextView) findViewById(R.id.tvdxadmin);
        auth = FirebaseAuth.getInstance();
        tvnameadmin = (TextView) findViewById(R.id.tvnameadmin);
        user = auth.getCurrentUser();
        if(user == null){
            Intent intent = new Intent(getApplicationContext(), LonginActivity.class);
            startActivity(intent);
            finish();
        } else {
            tvnameadmin.setText(user.getEmail());
        }


        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileUserActivity.this, HomeUserActivity.class);
                startActivity(intent);
            }
        });
        bt_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileUserActivity.this, CategoryUserActivity.class);
                startActivity(intent);
            }
        });
        tv_dangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LonginActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }
}