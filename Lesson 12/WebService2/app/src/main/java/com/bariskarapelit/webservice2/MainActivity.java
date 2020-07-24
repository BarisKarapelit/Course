package com.bariskarapelit.webservice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
{
    String url= "https://api.androidhive.info/volley/person_object.json";
    TextView sonuc;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,VeriGonder.class);
                startActivity(intent);

            }
        });
        sonuc =findViewById(R.id.sonuc);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                Log.w("data",response.toString());
                try
                {
                    String name = response.getString("name");
                    String email= response.getString("email");
                    JSONObject phone = response.getJSONObject("phone");
                    String  home= phone.getString("home");
                    String mobile= phone.getString("mobile");

                    Log.w("veri","dfhfgh"+mobile);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }



            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        }

        );
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);

    }
}