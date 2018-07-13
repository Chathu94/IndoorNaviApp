package com.example.dulajdilrukshan.indoorapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void logout(View view) {
        Intent logout = new Intent(this,LoginActivity.class);
        startActivity(logout);
    }

    public void navigate(View view) {
        Intent locate = new Intent(this,NavigateActivity.class);
        startActivity(locate);
    }
}
