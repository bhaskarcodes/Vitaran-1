/**
 * Created by Debanjana Kar
 */

package com.example.jayanta.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CollectionUI extends AppCompatActivity {

    public Button notify;

    public void init(){
        notify=(Button)findViewById(R.id.button);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMaps= new Intent(CollectionUI.this, MapsActivity.class);
                startActivity(openMaps);
            }
        });

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_ui);
        init();
    }
}
