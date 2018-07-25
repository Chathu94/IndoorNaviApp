package com.example.dulajdilrukshan.indoorapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

//    private static final String Login_email = "a";
//    private static final String Login_password = "a";


//    StringRequest MyStringRequest;
//    RequestQueue MyRequestQueue;
//    int success = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

//    public void pushData() {
//        final EditText username = (EditText) findViewById(R.id.txtloginusername);
//        final EditText password1 = (EditText) findViewById(R.id.txtloginpassword);
//
//        final String pusername = username.getText().toString();
//        final String pass1 = password1.getText().toString().trim();
//
//
//        final String url = "http://ec2-18-191-196-123.us-east-2.compute.amazonaws.com:8081/login";
//
//
//        MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
////                 Server Sends a Response as "true" if data is Success
//
//                    if (response == "true") {
//
//
//                        Toast.makeText(getApplicationContext(), "Registration Completed", Toast.LENGTH_SHORT).show();
//
//                    } else {
//
//                        Toast.makeText(getApplicationContext(), "Failed To Register", Toast.LENGTH_SHORT).show();
//                    }
//                } catch (Exception e) {
//                    String err = e.getMessage();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> FormData = new HashMap<String, String>();
//
//                FormData.put("username",pusername);
//                FormData.put("password",pass1);
//
//                return FormData;
//
//            }
//        };
//        MyRequestQueue.add(MyStringRequest);
//
//
//    }

    public void login(View view) {
//
//        final EditText username = (EditText) findViewById(R.id.txtloginusername);
//        final EditText password1 = (EditText) findViewById(R.id.txtloginpassword);
//
//        final String pusername = username.getText().toString();
//        final String pass1 = password1.getText().toString().trim();



//        try {
//            pushData();
//            Toast.makeText(getApplicationContext(), "data pushed", Toast.LENGTH_SHORT).show();
//
//
//        } catch (Exception e) {
//            String err = e.getMessage();
//            Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
//
//
//        }


//        if (puername.isEmpty()) {
//            username.setError("Username cannot be empty");
//            return;
//        }
//        if (pass1.isEmpty()) {
//            password1.setError("Password Cannot be Empty");
//            return;
//        }
//        if (!puername.isEmpty() && !pass1.isEmpty() ){
//
//            pushData();
////
//        }
//        if (success == 0){
//            Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_LONG).show();
//        }

////       Retrieving Data from signUp page
//
//        Bundle bn = getIntent().getExtras();
//        String data = bn.getString("isLogged");
//
////        To check the Data incoming .
//
//        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
//
        Intent home = new Intent(this, HomeActivity.class);
        startActivity(home);
    }

    public void register(View view) {
        Intent reg = new Intent(this, SignUpActivity.class);
        startActivity(reg);
    }
}
