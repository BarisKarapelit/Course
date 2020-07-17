package com.bariskarapelit.androidwebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String JSON_STRING="{\"employee\":{\"name\":\"Sachin\",\"salary\":56000}}";
        try
        {
            JSONObject emp = new JSONObject(JSON_STRING);
            JSONObject employeeObject=emp.getJSONObject("employee");
            String employeeName=employeeObject.getString("name");
            int employeeSalary=employeeObject.getInt("salary");
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        String JSON_STRING2="{" +
                "\"name\":\"John\"," +
                "\"age\":30," +
                "\"cars\":[ \"Ford\", \"BMW\", \"Fiat\" ]" +
                "}";
        try
        {
            JSONObject emp2= new JSONObject(JSON_STRING2);
            emp2.getString("name");
            emp2.getInt("age");
            JSONArray carsArray=emp2.getJSONArray("cars");

            String value=carsArray.getString(0);
            Log.w("value",value);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        String JSON_STRING3="{\n" +
                "    \"cars\": {\n" +
                "        \"Nissan\": [\n" +
                "            {\"model\":\"Sentra\", \"doors\":4},\n" +
                "            {\"model\":\"Maxima\", \"doors\":4},\n" +
                "            {\"model\":\"Skyline\", \"doors\":2}\n" +
                "        ],\n" +
                "        \"Ford\": [\n" +
                "            {\"model\":\"Taurus\", \"doors\":4},\n" +
                "            {\"model\":\"Escort\", \"doors\":4}\n" +
                "        ]\n" +
                "    }\n" +
                "}";

        Log.w("JSON",JSON_STRING3);

        try
        {
            JSONObject JSONObject = new JSONObject(JSON_STRING3);
            JSONObject carsObject =  JSONObject.getJSONObject("cars");
                JSONArray nissanArray = carsObject.getJSONArray("Nissan");
                for (int i=0;i<=2;i++)
                {
                   JSONObject nissan= nissanArray.getJSONObject(i);
                   String model = nissan.getString("model");
                   int doors= nissan.getInt("doors");

                }
                JSONArray fordArray = carsObject.getJSONArray("Ford");
                for (int i=0;i<=2;i++)
                {
                    JSONObject ford = fordArray.getJSONObject(i);
                    String model = ford.getString("model");
                    int doors= ford.getInt("doors");
                    Log.w("dadas",ford.getString("model"));
                }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }





    }
}