package com.example.wendel.horadalimpeza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AdicionarEquipamento extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_equipamento);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button bt = (Button) findViewById(R.id.bt_salvar);
        bt.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        Intent it = new Intent(this, Equips.class);
        it.putExtra("equip", R.id.equip);
        it.putExtra("local", R.id.local);
        it.putExtra("dt_u_man", R.id.dt_u_man);
        it.putExtra("period", R.id.period);
        startActivity(it);
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
