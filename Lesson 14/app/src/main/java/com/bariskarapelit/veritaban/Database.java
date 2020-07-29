package com.bariskarapelit.veritaban;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper
{
    private static int DATABASE_VERSION=1;
    private static String DATABASE_NAME="Pilates";

    public Database(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String create_table= "CREATE TABLE ipadres ( " +
                "ip_id INTEGER PRIMARY KEY AUTOINCREMENT, " +

                "subeName TEXT,"  +
                "ipadres TEXT)";

        sqLiteDatabase.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ipadress");
        this.onCreate(sqLiteDatabase);
    }
    public long insertIpadres(String ipadres,String subeName)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String table_name="ipadres";
        SQLiteStatement sqLiteStatement = db.compileStatement(""+"INSERT INTO "+table_name+
                "(subeName,ipadres)"+
                "VALUES (?,?)");
        sqLiteStatement.bindString(1,subeName);
        sqLiteStatement.bindString(2,ipadres);
        long rowId=sqLiteStatement.executeInsert();
        db.close();
        return rowId ;
    }
    public  void  deleteIpadres(String id)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        String [] arg={id};
        db.delete("ipadres","ip_id=?",arg);
        db.close();



    }

}
