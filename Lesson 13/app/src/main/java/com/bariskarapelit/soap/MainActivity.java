package com.bariskarapelit.soap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.transport.HttpsTransportSE;

import java.net.HttpCookie;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText tcText;
    EditText name,surname,birthdate;
    private static final String NAMESPACE = "http://tckimlik.nvi.gov.tr/WS";
    private static final String URL = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx";
    private static final String SOAP_ACTION = "http://tckimlik.nvi.gov.tr/WS/TCKimlikNoDogrula";
    private static final String METHOD_NAME = "TCKimlikNoDogrula";
     String resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tcText =findViewById(R.id.tcText);
        name=findViewById(R.id.nameText);
        surname=findViewById(R.id.surnameText);
        birthdate=findViewById(R.id.yearText);
        Button btn =findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent= new Intent(MainActivity.this,Permssion.class);
                startActivity(intent);
            }
        });

    }
    public  void click(View v)
    {
        String tcString =tcText.getText().toString().trim();
        String adText =name.getText().toString().trim().toUpperCase(new Locale("tr_TR"));
        String soyadString= surname.getText().toString().trim().toUpperCase(new Locale("tr_TR"));
        String yearText= birthdate.getText().toString().trim();

        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        SoapObject request =new SoapObject(NAMESPACE,METHOD_NAME);
        request.addProperty("TCKimlikNo",tcString);
        request.addProperty("Ad",adText);
        request.addProperty("Soyad",soyadString);
        request.addProperty("DogumYili",yearText);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.setOutputSoapObject(request);

        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try
        {
            androidHttpTransport.call(SOAP_ACTION,envelope);
            SoapObject response=(SoapObject)envelope.bodyIn;

            Boolean result=Boolean.parseBoolean(response.getProperty(0).toString());
            if (result)
            {
                resultText="Sistem Kayıtlı Kullanıcı Bulundu";
            }
            else
            {
                resultText="Sistem Kayıtlı Kullanıcı Bulunamadı";
            }

            Toast.makeText(MainActivity.this,resultText,Toast.LENGTH_LONG).show();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }





    }
}