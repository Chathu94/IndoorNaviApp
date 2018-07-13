package com.example.dulajdilrukshan.indoorapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void register(View view) {
        Intent signUp = new Intent(this,LoginActivity.class);
        startActivity(signUp);
    }
}
