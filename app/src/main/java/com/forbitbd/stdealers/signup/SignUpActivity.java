package com.forbitbd.stdealers.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.forbitbd.stdealers.R;

public class SignUpActivity extends AppCompatActivity {

    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
//                startActivity(intent);
            }
        });
    }
}