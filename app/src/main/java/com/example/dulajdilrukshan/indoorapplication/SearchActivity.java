package com.example.dulajdilrukshan.indoorapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextViewfrom;
    AutoCompleteTextView autoCompleteTextViewto;
    EditText fromtxt;
    EditText totxt;

    ArrayList<String> locations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        autoCompleteTextViewfrom = (AutoCompleteTextView) findViewById(R.id.direction_header_from_text);
        autoCompleteTextViewto = (AutoCompleteTextView) findViewById(R.id.direction_header_to_text);


        locations.add("Auditorium");
        locations.add("MSC Room");
        locations.add("Lecture Hall 1");
        locations.add("Multimedia Lab");
        locations.add("Library");
        locations.add("DCCN Lab");
        locations.add("Lift Lobby");
        locations.add("Staff Room");
        locations.add("Wash Rooms");
        locations.add("Common Room");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SearchActivity.this, android.R.layout.simple_spinner_dropdown_item, locations);

        autoCompleteTextViewfrom.setAdapter(adapter);
        autoCompleteTextViewto.setAdapter(adapter);

    }

    public void search(View view) {
        totxt = (EditText) findViewById(R.id.direction_header_to_text);
        fromtxt = (EditText) findViewById(R.id.direction_header_from_text);
        Intent intent = new Intent(this, PathActivity.class);
        // intent.putExtra("from",fromtxt.getText().toString());

        intent.putExtra("to", totxt.getText().toString());
        intent.putExtra("from", fromtxt.getText().toString());
        startActivity(intent);
        finish();
    }

    public  void  goback(View view){
        Intent goback = new Intent(this,HomeActivity.class);
        startActivity(goback);
    }

}
