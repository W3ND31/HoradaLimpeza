package com.example.wendel.horadalimpeza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class ContatExib extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contat_exib);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView txtequip = (TextView) findViewById(R.id.contat_text);

        Intent i = getIntent();
        String contat = i.getStringExtra("contat");
        txtequip.setText(contat);
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
