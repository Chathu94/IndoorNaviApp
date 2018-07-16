package com.example.dulajdilrukshan.indoorapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText emailText;
    EditText passwordText;

    private static final String Login_email = "abc";
    private static final String Login_password = "a";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailText = findViewById(R.id.txtloginemail);
        passwordText = findViewById(R.id.txtloginpassword);
    }

    public void login(View view) {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty()) {
            emailText.setError("Email cannot be empty");
            return;
        }
        if (password.isEmpty()) {
            passwordText.setError("Password Cannot be Empty");
            return;
        }

        String errorMessage = null;
        if (!email.equals(Login_email)) {
            errorMessage = "email is incorrect";

        } else if (!password.equals(Login_password)) {
            errorMessage = "Password is incorrect";
        }
        if (errorMessage == null) {
            Intent homeintent = new Intent(this, HomeActivity.class);
            startActivity(homeintent);

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage(errorMessage)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }

    public void register(View view) {
        Intent reg = new Intent(this,SignUpActivity.class);
        startActivity(reg);
    }
}
