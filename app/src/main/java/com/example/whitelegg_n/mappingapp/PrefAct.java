package com.example.whitelegg_n.mappingapp;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by 3hards79 on 12/02/2018.
 */

public class PrefAct extends PreferenceActivity{
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

}
