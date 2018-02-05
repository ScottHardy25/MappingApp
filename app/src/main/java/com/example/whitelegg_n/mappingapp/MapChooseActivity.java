package com.example.whitelegg_n.mappingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by 3hards79 on 05/02/2018.
 */

public class MapChooseActivity extends AppCompatActivity
implements View.OnClickListener {


        public void onCreate (Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_map_choose);

            Button btnRegular = (Button) findViewById(R.id.btnRegular),
                    btnHikeBikeMap = (Button) findViewById(R.id.btnHikeBikeMap);

            btnRegular.setOnClickListener(this);
            btnHikeBikeMap.setOnClickListener(this);
        }

        public  void onClick(View view){

            boolean hikebike = false;

            if (view.getId() == R.id.btnHikeBikeMap){
                hikebike = true;
            }

            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.example.whitelegg_n.mappingapp.hikebike", hikebike);
            Log.d("mapping", "in secondary activity: hikebike=" + hikebike);
            intent.putExtras(bundle);
            setResult(RESULT_OK, intent);
            finish();
        }




}
