package com.example.wendel.horadalimpeza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Contatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contatos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListView listView = (ListView)findViewById(android.R.id.list);
        // Guardando resources de String no Array
        String[] contat = getResources().getStringArray(R.array.equips);
        // Amarrando o Array no ListAdapter
        listView.setAdapter(new ArrayAdapter<String>(this,R.layout.list_item, R.id.label,contat));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String equip = ((TextView) view).getText().toString();
                if (equip.equals("ArCondicionado")){
                    String contat = getString(R.string.ContatArCondicionado);
                    Intent i = new Intent(getApplicationContext(),ContatExib.class);
                    i.putExtra("contat",contat);
                    startActivity(i);
                }else if(equip.equals("Geladeira")){
                    String contat = getString(R.string.Geladeira);
                    Intent i = new Intent(getApplicationContext(),ContatExib.class);
                    i.putExtra("contat",contat);
                    startActivity(i);
                }else if(equip.equals("Liquidificador")){
                    String contat = getString(R.string.Liquidificador);
                    Intent i = new Intent(getApplicationContext(),ContatExib.class);
                    i.putExtra("contat",contat);
                    startActivity(i);
                }else if(equip.equals("Microondas")){
                    String contat = getString(R.string.Microondas);
                    Intent i = new Intent(getApplicationContext(),ContatExib.class);
                    i.putExtra("contat",contat);
                    startActivity(i);
                }else if(equip.equals("Notebook")){
                    String contat = getString(R.string.Notebook);
                    Intent i = new Intent(getApplicationContext(),ContatExib.class);
                    i.putExtra("contat",contat);
                    startActivity(i);
                }else{
                    String contat = "Não Funcionou!";
                    Intent i = new Intent(getApplicationContext(),ContatExib.class);
                    i.putExtra("contat",contat);
                    startActivity(i);
                }
            }
        });
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
