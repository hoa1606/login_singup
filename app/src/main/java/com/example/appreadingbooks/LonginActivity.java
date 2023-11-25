package com.example.appreadingbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;


import com.google.firebase.auth.FirebaseAuth;

public class LonginActivity extends AppCompatActivity {

    EditText et_email,et_password;
    Button bt_login,bt_signUp;
    ProgressBar progress_bar;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), HomeUserActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longin);
        mAuth = FirebaseAuth.getInstance();
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_signUp = (Button) findViewById(R.id.bt_signup);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        progress_bar = (ProgressBar) findViewById(R.id.progress_bar);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress_bar.setVisibility(View.VISIBLE);
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(LonginActivity.this, "Please Enter your Email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(LonginActivity.this, "Please Enter your Password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progress_bar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), HomeUserActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(LonginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                // Kiểm tra tên người dùng và mật khẩu
                if (email.equals("admin") && password.equals("1234")) {
                    // Đăng nhập thành công, thực hiện các hành động tiếp theo
                    Intent intent = new Intent(LonginActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    // Đăng nhập thất bại, thông báo lỗi
                    Intent intent = new Intent(LonginActivity.this, HomeActivity.class);
                    startActivity(intent);


                }
            }
        });
        bt_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LonginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });




    }
}