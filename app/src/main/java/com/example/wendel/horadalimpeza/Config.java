package com.example.wendel.horadalimpeza;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CompoundButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

public class Config extends AppCompatActivity {
    Switch switch1, switch2;
    public static final String PREF_NAME = "Config";
    public static final String TEMA = "tema";
    SharedPreferences shp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        shp = getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        final SharedPreferences.Editor edt = shp.edit();
        boolean t = shp.getBoolean(TEMA,false);
//        if (t){
//            switch1.setChecked(true);
//        }else{
//            switch1.setChecked(false);
//        }
        switch1 = (Switch) findViewById(R.id.switch1);
//        switch2 = (Switch) findViewById(R.id.switch2);
//        switch1.setOnCheckedChangeListener(this);
//        switch2.setOnCheckedChangeListener(this);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {
                    edt.putBoolean(TEMA,true);
                    switch1.setChecked(true);
                    edt.commit();
                } else {
                    edt.putBoolean(TEMA,false);
                    switch1.setChecked(false);
                    edt.commit();
                }
            }
        });
//        if (t){
//            switch1.setChecked(true);
//        }else{
//            switch1.setChecked(false);
//        }

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
