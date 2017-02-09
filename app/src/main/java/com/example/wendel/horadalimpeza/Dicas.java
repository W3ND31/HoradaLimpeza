package com.example.wendel.horadalimpeza;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Dicas extends ListActivity {
    //TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dicas);
        ListView listView = (ListView)findViewById(android.R.id.list);
        //content = (TextView)findViewById(R.id.single_list_item_label);

        // Guardando resources de String no Array
        String[] equips = getResources().getStringArray(R.array.equips);
//        // Amarrando o Array no ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this,R.layout.list_item,R.id.label,equips));
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);
        int itemPosition = position;
        String itemValue = (String)l.getItemAtPosition(position);
        if (itemValue.equals("ArCondicionado")){
            String dica = getString(R.string.ArCondicionado);
            //content.setText(dica);
            Intent i = new Intent(this,DicaExib.class);
            i.putExtra("dica",dica);
            startActivity(i);
        }else if(itemValue.equals("Geladeira")){
            String dica = getString(R.string.Geladeira);
            //content.setText(dica);
            Intent i = new Intent(this,DicaExib.class);
            i.putExtra("dica",dica);
            startActivity(i);
        }else if(itemValue.equals("Liquidificador")){
            String dica = getString(R.string.Liquidificador);
            //content.setText(dica);
            Intent i = new Intent(this,DicaExib.class);
            i.putExtra("dica",dica);
            startActivity(i);
        }else if(itemValue.equals("Microondas")){
            String dica = getString(R.string.Microondas);
            //content.setText(dica);
            Intent i = new Intent(this,DicaExib.class);
            i.putExtra("dica",dica);
            startActivity(i);
        }else if(itemValue.equals("Notebook")){
            String dica = getString(R.string.Notebook);
            //content.setText(dica);
            Intent i = new Intent(this,DicaExib.class);
            i.putExtra("dica",dica);
            startActivity(i);
        }else{
            String dica = "Não Funcionou!";
            //content.setText(dica);
            Intent i = new Intent(this,DicaExib.class);
            i.putExtra("dica",dica);
            startActivity(i);
        }

//        Intent i = new Intent(this,DicaExib.class);
    }
}
