package com.example.whitelegg_n.mappingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 3hards79 on 15/02/2018.
 */

public class SetLocation extends AppCompatActivity implements View.OnClickListener  {
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        Button bntLoc = (Button) findViewById(R.id.btnLoc);

        bntLoc.setOnClickListener(this);

    }

    public  void onClick(View view){

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        // getting the text from activity layout .xml
        EditText etlon = (EditText)findViewById(R.id.lon);
        EditText etlat = (EditText)findViewById(R.id.lat);
        // Double.parseDouble= gets a double out of a string
        //(etlon.getText().toString()) takes an "editable" from edittext and makes it a string
        double sendbacklon = Double.parseDouble(etlon.getText().toString());
        double sendbacklat = Double.parseDouble(etlat.getText().toString());

        // inside "bundle"
        // taking the double from sendbacklon and putting it into bundle
        //---"com.example.whitelegg_n.mappingapp -- this is the app
        // -- .sblon" -- this is the unique key

        bundle.putDouble("com.example.whitelegg_n.mappingapp.sblon",sendbacklon);
        bundle.putDouble("com.example.whitelegg_n.mappingapp.sblat",sendbacklat);

        intent.putExtras(bundle);
        //indiacte where or not to process information
        setResult(RESULT_OK, intent);
        //  ends the current activity
        finish();

    }

}
