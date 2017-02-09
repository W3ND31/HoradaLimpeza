package com.example.wendel.horadalimpeza;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DicaExib extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dica_exib);

        getSupportActionBar();
        TextView txtequip = (TextView) findViewById(R.id.dica_text);

        Intent i = getIntent();
        String dica = i.getStringExtra("dica");
        txtequip.setText(dica);
    }

}
