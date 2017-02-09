package com.example.wendel.horadalimpeza;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class DicaExib extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dica_exib);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView txtequip = (TextView) findViewById(R.id.dica_text);

        Intent i = getIntent();
        String dica = i.getStringExtra("dica");
        txtequip.setText(dica);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

}
