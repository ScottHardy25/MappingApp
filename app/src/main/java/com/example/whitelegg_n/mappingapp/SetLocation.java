package com.example.whitelegg_n.mappingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 3hards79 on 15/02/2018.
 */

public class SetLocation extends AppCompatActivity {
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        Button bntLoc = (Button) findViewById(R.id.btnLoc);

        bntLoc.setOnClickListener(this);

    }

    public  void onClick(View view){
        /*

        take what is currently in long feild and set it to long var
           take what is currently in lat feild and set it to lat var
         */

    }

}
