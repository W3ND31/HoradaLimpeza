package com.example.wendel.horadalimpeza;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class Equips extends AppCompatActivity {
//    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.equips);
        ListView listView = (ListView)findViewById(android.R.id.list);
        final Intent it = new Intent(this, AdicionarEquipamento.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(it);
            }
        });
//         Guardando resources de String no Array
        String[] equips = getResources().getStringArray(R.array.equip);
//         Amarrando o Array no ListAdapter
        listView.setAdapter(new ArrayAdapter<String>(this,R.layout.list_item,R.id.label,equips));

//        ListView lv = getListView();
//
//        lv.setOnItemClickListener(new OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//				String equip = ((TextView) view).getText().toString();
//				Intent i = new Intent(getApplicationContext(),SingleListItem.class);
//				i.putExtra("equip", equip);
//				startActivity(i);
//			}
//		});
//        content = (TextView)findViewById(R.id.single_list_item_label);
//
//        // Guardando resources de String no Array
//        String[] equips = getResources().getStringArray(R.array.equips);
////        // Amarrando o Array no ListAdapter
//        this.setListAdapter(new ArrayAdapter<String>(this,R.layout.list_item,R.id.label,equips));
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
