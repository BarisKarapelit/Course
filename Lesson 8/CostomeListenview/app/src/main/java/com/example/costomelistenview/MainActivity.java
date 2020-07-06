package com.example.costomelistenview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ArrayList<HashMap<String,Object>> booklist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list =(ListView)findViewById(R.id.list);

        booklist = new ArrayList<>();

        HashMap<String,Object> book =new HashMap<>();
        book.put("Name","Elif gibi Sevmek");
        book.put("image","https://smality.com/elif.jpg");




        HashMap<String,Object>book2=new HashMap<>();

        book2.put("Name","Amok");
        book2.put("image","https://smality.com/amok.jpg");

        booklist.add(book);
        booklist.add(book2);

        BookAdapter adapter = new BookAdapter(MainActivity.this,booklist);

        list.setAdapter(adapter);



       /* HashMap<String , String> cities =new HashMap<String, String>();
        cities.put(" City 1","Istanbul");
        cities.put(" City 2","Ankara");
        cities.put(" City 3","Sivas");
        cities.put(" City 4","Ardahan");
        System.out.println(cities);
        Log.w("City 3",cities.get("City 3"));*/



    }
}