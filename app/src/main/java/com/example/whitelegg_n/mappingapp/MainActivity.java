package com.example.whitelegg_n.mappingapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity {

    MapView mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Configuration.getInstance().load
                (this, PreferenceManager.getDefaultSharedPreferences(this));
        setContentView(R.layout.activity_main);

        mv = (MapView)findViewById(R.id.map1);

        if(mv!=null) {
            mv.setBuiltInZoomControls(true);

            mv.getController().setZoom(16);
            mv.getController().setCenter(new GeoPoint(51.05, -0.72));
        }
    }

   /*
    public void onStart(){
        super.onStart();
        new AlertDialog.Builder(this).
                setPositiveButton("ok", null).setMessage("onStart() called").show();
    }

    public void onStop(){
        super.onStop();
        Toast.makeText(this, "onstop() call", Toast.LENGTH_LONG).show();
    }


    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "oneDstroy() call", Toast.LENGTH_LONG).show();
    }
*/
    public boolean onCreateOptionsMenu (Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item)
    {
        if(item.getItemId() == R.id.choosemap)
        {
            Intent intent = new Intent(this, MapChooseActivity.class);
            startActivityForResult(intent, 0);


            return true;
        }
        else if (item.getItemId() == R.id.pref){

            Intent intent = new Intent(this, PrefAct.class);
            startActivityForResult(intent, 2);
        }
        else if (item.getItemId() == R.id.loc){

            Intent intent = new Intent(this, SetLocation.class);
            startActivityForResult(intent,1);
        }
        return false;
    }

    public void onActivityResult (int requestCode, int resultCode, Intent returnIntent){
        if (resultCode == RESULT_OK){
            //set in onOptionsItemSelected
            if (requestCode == 0){

                Bundle bundle = returnIntent.getExtras();
                boolean hikebike = bundle.getBoolean("com.example.whitelegg_n.mappingapp.hikebike");
                Log.d("mapping", "hikebike=" + hikebike);
                if (hikebike){
                    mv.setTileSource(TileSourceFactory.HIKEBIKEMAP);
                }
                else
                {
                    mv.setTileSource(TileSourceFactory.MAPNIK);
                }
            }
            else if(requestCode == 1){
                //take returned intent and get the bundle out
                Bundle bundle = returnIntent.getExtras();
                /*   makes a new var called lon, then opens the bundle and takes these:
                --
                bundle.putDouble("com.example.whitelegg_n.mappingapp.sblon",sendbacklon);
                bundle.putDouble("com.example.whitelegg_n.mappingapp.sblat",sendbacklat);
                --
                out of the bundle and then uses getDouble to get the data, using the keys
                it then repeats it again for lat
                */

                double lon = bundle.getDouble("com.example.whitelegg_n.mappingapp.sblon");
                double lat = bundle.getDouble("com.example.whitelegg_n.mappingapp.sblat");
                mv.getController().setCenter(new GeoPoint(lat,lon));
            }
        }
    }
}
