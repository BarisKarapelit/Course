package com.bariskarapelit.veritaban;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity
{
    Database db ;
    TextView list;
    String dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        db=new Database(DetayActivity.this);
        list=findViewById(R.id.list);


        SQLiteDatabase sqLiteDatabase= db.getReadableDatabase();
        String[] colomn ={"ip_id","subeName","ipadres"};

        Cursor cursor =sqLiteDatabase.query("ipadres",colomn,null,null,null
        ,null,null);
        while (cursor.moveToNext())
        {
            String subeNumberDeger= cursor.getString(cursor.getColumnIndex("subeName"));
            String ipadresDeger= cursor.getString(cursor.getColumnIndex("ipadres"));
            String id=String.valueOf(cursor.getInt(cursor.getColumnIndex("ip_id")));
            dataList= dataList+ " id "+id+" Şube Name "+subeNumberDeger+" Ip adres "+ipadresDeger+ "\n";
            list.setText(dataList);
        }
        cursor.close();
        db.close();
        //silme işlemi

        db.deleteIpadres("2");

    }
}