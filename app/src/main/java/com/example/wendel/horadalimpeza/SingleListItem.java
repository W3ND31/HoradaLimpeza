package com.example.wendel.horadalimpeza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class SingleListItem extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_list_item_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView txtequip = (TextView) findViewById(R.id.single_list_item_label);

        Intent i = getIntent();
//        String equip = i.getStringExtra("equip");
        String dica = i.getStringExtra("dica");
        txtequip.setText(dica);
//        txtequip.setText(equip);
    }
}
