package com.example.rals.preferenciasheader;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.Menu;
import android.view.MenuItem;


public class FragmentHeader extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String settings = getArguments().getString("ajustes");

        if ("header_fondo".equals(settings)){
            addPreferencesFromResource(R.xml.preferencias_fondo);
        }
        else if ("header_texto".equals(settings)){
            addPreferencesFromResource(R.xml.preferencias_texto);
        }
    }
}
