package com.bariskarapelit.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
TextView Screen;
Button AC,Power,Back,Div,Mul, Plus, Min,Point,Equal,One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Zero,
        Ans;
String input,Answer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Screen=(TextView)findViewById(R.id.screen);

        AC=(Button)findViewById(R.id.ac);
        Back=(Button)findViewById(R.id.back);
        Point=(Button)findViewById(R.id.point);

        Div=(Button)findViewById(R.id.div);
        Mul=(Button)findViewById(R.id.mul);
        Plus =(Button)findViewById(R.id.sum);
        Min =(Button)findViewById(R.id.min);
        Power=(Button)findViewById(R.id.power);
        Ans=(Button)findViewById(R.id.ans);
        Equal=(Button)findViewById(R.id.equal);



        Zero=(Button)findViewById(R.id.zero);
        One=(Button)findViewById(R.id.one);
        Two=(Button)findViewById(R.id.two);
        Three=(Button)findViewById(R.id.three);
        Four=(Button)findViewById(R.id.four);
        Five=(Button)findViewById(R.id.five);
        Six=(Button)findViewById(R.id.six);
        Seven=(Button)findViewById(R.id.seven);
        Eight=(Button)findViewById(R.id.eight);
        Nine=(Button)findViewById(R.id.nine);




    }
    public  void  ButtonClick(View view)
    {
        Button button =(Button) view;
        String data = button.getText().toString();
        switch (data)
        {
            case"AC":
                input="";
            case "Ans":
                input+=Answer;
                break;
            case "x":
                Solve();
                input+="*";
                break;
            case "^":
                Solve();
                input+="^";
                break;
            case"=":
                Solve();
                Answer=input;
                break;
            case "←":
                String newText=input.substring(0,input.length()-1);
                input=newText;
                break;
            default:
                if (input==null)
                {
                    input="";
                }
                if ((data.equals("+") || data.equals("-") || data.equals("/")))
            {
                    Solve();
            }
            input+=data;
        }
        Screen.setText(input);
    }
    private void Solve()
    {
        if (input.split("\\*").length==2)
        {
            String number[]=input.split("\\*");
            try
            {
                double mul=Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                input=mul+"";
            } catch (Exception e)
            {

            }
        }
        else if (input.split("/").length==2)
        {
            String number[] = input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div+"";
            } catch (Exception e)
            {

            }
        }
        else if (input.split("\\^").length==2)
        {
            String number[] = input.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]) ,Double.parseDouble(number[1]));
                input = pow+"";
            } catch (Exception e)
            {

            }
        }
        else if (input.split("\\+").length==2)
        {
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum+"";
            } catch (Exception e)
            {

            }
        }
        else if (input.split("-").length>1)
        {
            String number[] = input.split("-");
            if (number[0]==""&&number.length==2)
            {
                number[0]=0+"";
            }
            try {
                double sub=0;
                if (number.length==2)
                {
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if (number.length==3)
                {
                    sub = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }

                input = sub+"";
            } catch (Exception e)
            {

            }
        }
        String n[]=input.split("\\.");
        if (n.length>1)
        {
            if (n[1].equals("0"))
            {
                input=n[0];
            }
        }
        Screen.setText(input);
    }
}