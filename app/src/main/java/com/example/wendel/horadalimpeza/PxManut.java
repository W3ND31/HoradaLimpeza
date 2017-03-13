package com.example.wendel.horadalimpeza;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class PxManut extends AppCompatActivity {
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.px_manut);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        ListView listView = (ListView)findViewById(android.R.id.list);
//        // Guardando resources de String no Array
//        String[] px_manut = getResources().getStringArray(R.array.px_manut);
//        // Amarrando o Array no ListAdapter
//        listView.setAdapter(new ArrayAdapter<String>(this,R.layout.list_item, R.id.label,px_manut));
        BDController crud = new BDController(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {BDCreate.EC_EQP_ID,BDCreate.EC_DPM_TX};
        int[] idViews = new int[] {R.id.pm_eqp,R.id.pm_data};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),R.layout.px_manut_layout,cursor,nomeCampos,idViews,0);
        lista = (ListView)findViewById(android.R.id.list);
        lista.setAdapter(adaptador);
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
