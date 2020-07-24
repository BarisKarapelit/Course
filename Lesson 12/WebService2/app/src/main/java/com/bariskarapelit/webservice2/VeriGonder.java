package com.bariskarapelit.webservice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class VeriGonder extends AppCompatActivity
{
    RequestQueue requestQueue;
    String url ="https://tugbaustundag.com/insertUser.php";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veri_gonder);

        requestQueue=AppController.getInstance().getRequestQueue();

        JSONObject jsonObject = new JSONObject();
        try
        {
            jsonObject.put("user_name","Baris");
            jsonObject.put("user_email","bkarapelit48@gmail.com");
            jsonObject.put("pass","dadadadasasa");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new
                Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {

                    }
                }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(VeriGonder.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
        );
        requestQueue.add(jsonObjectRequest);
    }
}