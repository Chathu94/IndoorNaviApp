package com.example.dulajdilrukshan.indoorapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


    }


    public void register(View view) {


        final EditText name = (EditText) findViewById(R.id.txtname);
        final EditText username = (EditText) findViewById(R.id.txtsingupusername);
        final EditText password1 = (EditText) findViewById(R.id.txtpassword1);
        final EditText password2 = (EditText) findViewById(R.id.txtpassword2);
        final EditText emailValidate = (EditText) findViewById(R.id.txtsignupemail);


        String email = emailValidate.getText().toString().trim();
        String pname = name.getText().toString();
        String puername = username.getText().toString();
        String pass1 = password1.getText().toString().trim();
        String pass2 = password2.getText().toString().trim();
        if (pname.isEmpty()) {
            name.setError("Name Cannot be Empty");
        }
        if (puername.isEmpty()) {
            username.setError("Username Cannot be Empty");
        }
        if (email.isEmpty()) {
            emailValidate.setError("Email Cannot be Empty");

        } else if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            emailValidate.setError("Invalid Email Address");
        }
        if (pass1.isEmpty()) {
            password1.setError("Password Cannot be Empty");
        }
        if (pass1.length() < 6) {
            password1.setError("Password Must be 6 characters");
        }
        if (!pass2.equals(pass1)) {
            password2.setError("Passwords do not Match");
        }
        if (pass1.equals(pass2) && !email.isEmpty() && !pname.isEmpty() && !puername.isEmpty() && !pass1.isEmpty() && !pass2.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();

            Intent signUp = new Intent(this, LoginActivity.class);

//          Sending data for other activities. You can call pname by using the key "isLogged"

            signUp.putExtra("isLogged", pname);
            startActivity(signUp);
        }


    }


}
