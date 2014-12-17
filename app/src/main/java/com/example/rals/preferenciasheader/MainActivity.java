package com.example.rals.preferenciasheader;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener{

    private Button btnPref, btnRecuperar;
    private TextView lblTexo;
    private SharedPreferences prf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPref = (Button)findViewById(R.id.btn_preferencias);
        btnPref.setOnClickListener(this);

        btnRecuperar = (Button)findViewById(R.id.btn_recuperar);
        btnRecuperar.setOnClickListener(this);

        lblTexo = (TextView)findViewById(R.id.lbl_texto);

        prf = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_preferencias:
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                break;
            case R.id.btn_recuperar:

                lblTexo.setText(prf.getString("texto", "No encontre preferencia"));
                lblTexo.setTextSize(Float.parseFloat(prf.getString("texto_tamaño", "10")));
                lblTexo.setTextColor(Color.parseColor(prf.getString("fondo", "#000000")));

                break;
        }
    }
}
