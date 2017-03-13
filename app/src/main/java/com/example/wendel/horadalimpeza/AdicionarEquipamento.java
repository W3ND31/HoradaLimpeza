package com.example.wendel.horadalimpeza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AdicionarEquipamento extends AppCompatActivity
        implements View.OnClickListener {
    private BDCreate banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_equipamento);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Spinner eqp_spinner = (Spinner) findViewById(R.id.pm_eqp_tx);
        Spinner dma_spinner = (Spinner) findViewById(R.id.dma);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> eqp_adapter = ArrayAdapter.createFromResource(this,R.array.equips, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> dma_adapter = ArrayAdapter.createFromResource(this,R.array.dma, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        eqp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dma_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        eqp_spinner.setAdapter(eqp_adapter);
        dma_spinner.setAdapter(dma_adapter);
        Button botao = (Button)findViewById(R.id.bt_salvar);

        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Pegando os dados dos editText
                EditText ec_local = (EditText)findViewById(R.id.pm_data_txt);
                EditText dd = (EditText)findViewById(R.id.dd);
                EditText mm = (EditText)findViewById(R.id.mm);
                EditText yyyy = (EditText)findViewById(R.id.yyyy);
                EditText qtde = (EditText)findViewById(R.id.qtde);
                Spinner dma = (Spinner)findViewById(R.id.dma);
                Spinner ec_eqp_id = (Spinner)findViewById(R.id.pm_eqp_tx);

                //Método de como transformar um String em Int: Integer.parseInt(myEditText.getText().toString())
                String id = ec_eqp_id.getSelectedItem().toString();
                String local = ec_local.getText().toString();
                String dia = dd.getText().toString();
                String mes = mm.getText().toString();
                String ano = yyyy.getText().toString();
                String qtd = qtde.getText().toString();
                String adm = dma.getSelectedItem().toString();

                
                if(TextUtils.isEmpty(local) || TextUtils.isEmpty(dia) || TextUtils.isEmpty(mes) || TextUtils.isEmpty(ano) || TextUtils.isEmpty(qtd)){
                    Toast.makeText(getApplicationContext(),"Insira as Informações Corretamente",Toast.LENGTH_LONG).show();
                }else if (Integer.parseInt(mes)>12){
                    Toast.makeText(getApplicationContext(), "Mês Inválido", Toast.LENGTH_LONG).show();
                }else if(Integer.parseInt(mes)==2 && Integer.parseInt(dia)>28){
                    Toast.makeText(getApplicationContext(),"Dia Inválido",Toast.LENGTH_LONG).show();
                }else if((Integer.parseInt(mes)==1 || Integer.parseInt(mes)==3 || Integer.parseInt(mes)==5 || Integer.parseInt(mes)==7 || Integer.parseInt(mes)==8 || Integer.parseInt(mes)==10 || Integer.parseInt(mes)==12) && Integer.parseInt(dia)>31){
                    Toast.makeText(getApplicationContext(),"Dia Inválido",Toast.LENGTH_LONG).show();
                }else if((Integer.parseInt(mes)==4 || Integer.parseInt(mes)==6 || Integer.parseInt(mes)==9 || Integer.parseInt(mes)==11) && Integer.parseInt(dia)>30){
                    Toast.makeText(getApplicationContext(),"Dia Inválido",Toast.LENGTH_LONG).show();
                }else {
                    BDController crud = new BDController(getBaseContext());
                    int qt = Integer.parseInt(qtde.getText().toString());
                    String resultado;
                    //Realizando a inserção dos dados no banco de dados.
                    String pei = "";
                    if (adm.equals("Dia(s)")) {
                        pei = "day";
                    } else if (adm.equals("Mes(es)")) {
                        pei = "month";
                    } else if (adm.equals("Ano(s)")) {
                        pei = "year";
                    }
                    resultado = crud.insereDado(id, local, ano + "-" + mes + "-" + dia, qt, adm);

                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    if (!resultado.equals("-1")) {
                        crud.updateEcDpm(qt,pei);
                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                        Intent it = new Intent(getApplicationContext(), Equips.class);
                        startActivity(it);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Erro de BD", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
    @Override
    public void onClick(View view){
        Intent it = new Intent(this, Equips.class);
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
