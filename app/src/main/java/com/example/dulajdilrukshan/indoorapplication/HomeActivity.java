package com.example.dulajdilrukshan.indoorapplication;


import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    public void logout(View view) {
        Intent logout = new Intent(this, LoginActivity.class);
        startActivity(logout);
        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.clear();
    }

    public void navigate(View view) {


        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = mPreferences.edit();
        String name = mPreferences.getString(getString(R.string.pusername), "");

        //Toast.makeText(getApplicationContext(),name, Toast.LENGTH_SHORT).show();


        startActivity(new Intent(HomeActivity.this,PathActivity.class));

//        Intent search = new Intent(this, SearchActivity.class);
//        startActivity(search);
    }
}
