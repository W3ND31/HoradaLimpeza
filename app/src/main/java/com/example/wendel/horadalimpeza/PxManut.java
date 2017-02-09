package com.example.wendel.horadalimpeza;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class PxManut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.px_manut);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListView listView = (ListView)findViewById(android.R.id.list);
        // Guardando resources de String no Array
        String[] px_manut = getResources().getStringArray(R.array.px_manut);
        // Amarrando o Array no ListAdapter
        listView.setAdapter(new ArrayAdapter<String>(this,R.layout.list_item, R.id.label,px_manut));
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
