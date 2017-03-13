package com.example.wendel.horadalimpeza;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Equips extends AppCompatActivity {
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.equips);
//        ListView listView = (ListView)findViewById(android.R.id.list);
        final Intent it = new Intent(this, AdicionarEquipamento.class);
//
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(it);
                finish();
            }
        });
////         Guardando resources de String no Array
//        String[] equips = getResources().getStringArray(R.array.equip);
////         Amarrando o Array no ListAdapter
//        listView.setAdapter(new ArrayAdapter<String>(this,R.layout.list_item,R.id.label,equips));
        BDController crud = new BDController(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {BDCreate.EC_EQP_ID, BDCreate.EC_LOCAL,BDCreate.EC_DUM_TX, BDCreate.EC_QTDE,BDCreate.EC_DMA};
        int[] idViews = new int[] {R.id.eqp, R.id.pm_data, R.id.ec_dum, R.id.ec_qtde,R.id.ec_dma};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),R.layout.equip_layout,cursor,nomeCampos,idViews,0);
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
