package com.example.harshit.vitaran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DonorSuccess extends AppCompatActivity {
    TextView tw,tw2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_success);
        tw = (TextView)findViewById(R.id.textView);
    }
}
