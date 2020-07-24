package com.bariskarapelit.homework6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class DataSend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_send);

        JSONObject jsonObject = new JSONObject();
        try
        {
            jsonObject.put("user_name","Barış");
            jsonObject.put("user_email","baris_karapelit_298@hotmail.com");
            jsonObject.put("pass","12324rewre");

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        String url ="https://tugbaustundag.com/insertUser.php";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(DataSend.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}