package com.example.wendel.horadalimpeza;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Dicas extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.dicas);
        ListView listView = (ListView)findViewById(android.R.id.list);

        // Guardando resources de String no Array
        String[] equips = getResources().getStringArray(R.array.equips);
//        // Amarrando o Array no ListAdapter
        // Documentar os parâmetros do setAdapter
        listView.setAdapter(new ArrayAdapter<String>(this,R.layout.list_item,R.id.label,equips));

//
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
				String equip = ((TextView) view).getText().toString();
                if (equip.equals("Ar-Condicionado")){
                    String dica = getString(R.string.ArCondicionado);
                    Intent i = new Intent(getApplicationContext(),DicaExib.class);
                    i.putExtra("dica",dica);
                    startActivity(i);
                }else if(equip.equals("Geladeira")){
                    String dica = getString(R.string.Geladeira);
                    Intent i = new Intent(getApplicationContext(),DicaExib.class);
                    i.putExtra("dica",dica);
                    startActivity(i);
                }else if(equip.equals("Liquidificador")){
                    String dica = getString(R.string.Liquidificador);
                    Intent i = new Intent(getApplicationContext(),DicaExib.class);
                    i.putExtra("dica",dica);
                    startActivity(i);
                }else if(equip.equals("Microondas")){
                    String dica = getString(R.string.Microondas);
                    Intent i = new Intent(getApplicationContext(),DicaExib.class);
                    i.putExtra("dica",dica);
                    startActivity(i);
                }else if(equip.equals("Notebook")){
                    String dica = getString(R.string.Notebook);
                    Intent i = new Intent(getApplicationContext(),DicaExib.class);
                    i.putExtra("dica",dica);
                    startActivity(i);
                }else{
                    String dica = "Não Funcionou!";
                    Intent i = new Intent(getApplicationContext(),DicaExib.class);
                    i.putExtra("dica",dica);
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
