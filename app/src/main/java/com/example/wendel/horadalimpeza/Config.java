package com.example.wendel.horadalimpeza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Config extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
