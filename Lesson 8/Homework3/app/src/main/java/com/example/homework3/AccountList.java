package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class AccountList extends AppCompatActivity
{
    ArrayList<HashMap<String,Object>> booklist;
    TextView userTextView;
    String extrasStr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_list);

        ListView list =(ListView)findViewById(R.id.listView);

        booklist = new ArrayList<>();

        HashMap<String,Object> book = new HashMap<>();

        book.put("Name","Amok ");
        book.put("image","https://smality.com/amok.jpg");

        HashMap<String,Object> book2 =new HashMap<>();

        book2.put("Name","Elif gibi sevmek ");
        book2.put("image","http://www.tugbaustundag.com/wp-content/uploads/2018/11/android-security-1.jpg");

        booklist.add(book);
        booklist.add(book2);

        BookAdapter adapter = new BookAdapter(AccountList.this,booklist);

        list.setAdapter(adapter);

        userTextView=(TextView)findViewById(R.id.user);

        Bundle extras = getIntent().getExtras();

        if(extras!=null)
        {
            extrasStr=extras.getString("user");
            userTextView.setText(extrasStr);
        }



    }
}