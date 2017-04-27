package com.example.harshit.vitaran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PledgeDonation extends AppCompatActivity {

    private Spinner spinner,spinner3,spinner4,spinner5;
    private ArrayList<String> students;
    private JSONArray result;
    private TextView textViewName;
    private TextView textViewCourse;
    private TextView textViewSession;
    EditText editText3,editText2;
    Button button,button2;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_pledge);
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        spinner4 = (Spinner)findViewById(R.id.spinner4);
        spinner5 = (Spinner)findViewById(R.id.spinner5);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
     button2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent myIntent = new Intent(PledgeDonation.this, ManageDonation.class);
             startActivity(myIntent);

         }
     });

    }
}

