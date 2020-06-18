package com.example.aninterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name ,surname ,totalText;


    EditText nameInput;
    EditText surnameInput;
    RadioButton rMan, rWoman;
    CheckBox universitySchool ,elemantarySchool,firsSchool;
    Button sendButton;
    Spinner cities;
    ArrayAdapter<String> cityArrayAdaptor;
    ArrayAdapter<String> langeusArrayAdaptor;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        String[] city = {"Ankara","İstanbul","Ardahan"};
        final String[]  launges={"C","C++","JAVA"};

        list=(ListView)findViewById(R.id.list);
        langeusArrayAdaptor=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,launges);
        list.setAdapter(langeusArrayAdaptor);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String secilenItem=langeusArrayAdaptor.getItem(i);

                Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG).show();
            }
        });



        /*
        nameInput=(EditText)findViewById(R.id.name);
        surnameInput=(EditText)findViewById(R.id.surname);
        rMan=(RadioButton)findViewById(R.id.man);
        universitySchool=(CheckBox)findViewById(R.id.university);
        elemantarySchool=(CheckBox)findViewById(R.id.Elemantary);
        firsSchool=(CheckBox)findViewById(R.id.collagel);
        cities=(Spinner)findViewById(R.id.spinner);

        cityArrayAdaptor= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,city);
        cityArrayAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cities.setAdapter((cityArrayAdaptor)); */


        /*
        cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(MainActivity.this,cities.getItemAtPosition(i).toString(),Toast.LENGTH_LONG).show();
                cities.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        sendButton=(Button)findViewById(R.id.sendButton);*/

       /* sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    name=nameInput.getText().toString();
                    surname=surnameInput.getText().toString();

                    if(name!="")
                    {

                        if (surname!="")
                        {
                            totalText=name+" " +surname;
                        }
                    }
                    else
                    {
                        totalText=null;
                    }

                    Toast.makeText(MainActivity.this,totalText,Toast.LENGTH_LONG).show();

                }
            }
        );*/



    }

}