package com.example.lessonconstrainlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
String[] sehirler= {"Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Aksaray", "Amasya",
        "Ankara", "Antalya", "Ardahan", "Artvin", "Aydın", "Balıkesir","Bartın", "Batman",
        "Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
        "Çankırı", "Çorum", "Denizli",
        "Diyarbakır", "Düzce", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun",
        "Gümüşhane"," Hakkâri", "Hatay", "Iğdır", "Isparta", "İstanbul", "İzmir", "Kahramanmaraş", "Karabük", "Karaman",
        "Kars", "Kastamonu", "Kayseri", "Kilis", "Kırıkkale"," Kırklareli", "Kırşehir", "Kocaeli","Konya", "Kütahya",
        "Malatya"," Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Osmaniye", "Rize", "Sakarya",
        "Samsun", "Şanlıurfa", "Siirt", "Sinop", "Sivas", "Şırnak", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Uşak", "Van",
        "Yalova", "Yozgat", "Zonguldak"};
String[] ilcelerArray;



    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapterIlceler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Spinner
        Spinner sehirlerSp =(Spinner)findViewById(R.id.spinner);
        Spinner ilcelerSp=(Spinner)findViewById(R.id.spinner2);



        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,sehirler);
        adapterIlceler = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ilcelerArray);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sehirlerSp.setAdapter(adapter);
        ilcelerSp.setAdapter(adapterIlceler);




        sehirlerSp.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        Toast.makeText(getApplicationContext(),"Select Şehir :" +sehirler[i],Toast.LENGTH_LONG).show();
        String secilenSehir= adapter.getItem(i);
        resetCity(secilenSehir);
        Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG).show();
    }

    private void resetCity(String secilenSehir)
    {
        //you can also get a cursor and add Strings as options to city_options instead of what i have done
        if(secilenSehir.equals("Adana"))
        {
            ilcelerArray = new String[]{"Aladağ", "Ceyhan", "Çukurova", "Feke", "İmamoğlu", "Karaisalı"};
        }
        else if (secilenSehir.equals("Ardahan"))
        {

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
}