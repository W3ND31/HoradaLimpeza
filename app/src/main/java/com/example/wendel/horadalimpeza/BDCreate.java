package com.example.wendel.horadalimpeza;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;


public class BDCreate extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "hl.db";
    public static final String TABELA_EQP = "eqp";
    public static final String EQP_ID = "_id";
    public static final String EQP_NOME = "eqp_nome";
    public static final String TABELA_EC = "ec";
    public static final String EC_ID = "_id";
    public static final String EC_EQP_ID = "ec_eqp_id";
    public static final String EC_LOCAL = "ec_local";
    public static final String EC_DUM = "ec_dum";
    public static final String EC_QTDE = "ec_qtde";
    public static final String EC_DMA = "ec_dma";
    public static final String EC_DPM = "ec_dpm";
    public static final String EC_DUM_TX = "ec_dum_tx";
    public static final String EC_DPM_TX = "ec_dpm_tx";
    public static final int VERSAO = 1;

    public BDCreate (Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE " + TABELA_EC + " ("
                + EC_ID + " integer primary key autoincrement, "
                + EC_EQP_ID + " text, "
                + EC_LOCAL + " text, "
                + EC_DUM + " text, "
                + EC_DPM + " text, "
                + EC_QTDE + " integer, "
                + EC_DMA + " text,"
                + EC_DUM_TX + " text,"
                + EC_DPM_TX + " text"
                + ")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_EC);
        onCreate(db);

    }

}
