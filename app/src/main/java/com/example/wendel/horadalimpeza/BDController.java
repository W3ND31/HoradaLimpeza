package com.example.wendel.horadalimpeza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Wendel on 12/03/2017.
 */

public class BDController {
    private SQLiteDatabase db;
    private BDCreate banco;

    public BDController (Context context){
        banco = new BDCreate(context);
    }

    public String insereDado(String ec_eqp_id, String ec_local, String ec_dum, int ec_qtde, String ec_dma){
        ContentValues valores;
        long resultado;
        ec_dma = ' ' + ec_dma;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BDCreate.EC_EQP_ID, ec_eqp_id);
        valores.put(BDCreate.EC_LOCAL, ec_local);
        valores.put(BDCreate.EC_DUM, ec_dum);
        valores.put(BDCreate.EC_QTDE, ec_qtde);
        valores.put(BDCreate.EC_DMA, ec_dma);

        resultado = db.insert(BDCreate.TABELA_EC, null, valores);
        db.close();

        if (resultado ==-1)
            return "-1";
        else
            return "Registro Inserido com sucesso";
    }
    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos = {banco.EC_ID,banco.EC_EQP_ID,banco.EC_LOCAL,banco.EC_DUM,banco.EC_QTDE,banco.EC_DMA,banco.EC_DPM,banco.EC_DPM_TX,banco.EC_DUM_TX};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA_EC, campos,null,null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
    public void updateEcDpm(int qt, String pei){
        db = banco.getWritableDatabase();
        String[] campos = {banco.EC_ID,banco.EC_EQP_ID,banco.EC_LOCAL,banco.EC_DUM,banco.EC_QTDE,banco.EC_DMA,banco.EC_DPM,banco.EC_DPM_TX,banco.EC_DUM_TX};
        String strSQL ="UPDATE "+ BDCreate.TABELA_EC+" SET "+BDCreate.EC_DPM+ " = date("+ BDCreate.EC_DUM+", '+"+qt+" "+pei+"') WHERE "+BDCreate.EC_ID+" = (SELECT MAX("+BDCreate.EC_ID+") from "+BDCreate.TABELA_EC+")";
        String strSQL2 = "UPDATE "+ BDCreate.TABELA_EC+" SET "+BDCreate.EC_DPM_TX+ " = strftime('%d/%m/%Y',"+BDCreate.EC_DPM+") WHERE "+BDCreate.EC_ID+" = (SELECT MAX("+BDCreate.EC_ID+") from "+BDCreate.TABELA_EC+")";;
        String strSQL3 = "UPDATE "+ BDCreate.TABELA_EC+" SET "+BDCreate.EC_DUM_TX+ " = strftime('%d/%m/%Y',"+BDCreate.EC_DUM+") WHERE "+BDCreate.EC_ID+" = (SELECT MAX("+BDCreate.EC_ID+") from "+BDCreate.TABELA_EC+")";;
        db.execSQL(strSQL);
        db.execSQL(strSQL2);
        db.execSQL(strSQL3);
        db.close();
    }
}
