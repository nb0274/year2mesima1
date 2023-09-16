package com.example.year2mesima1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView seriesList;
    ArrayAdapter<Double> adapterForList;
    TextView x1;
    TextView d;
    TextView n;
    TextView sn;
    Intent in;
    String mathmaticalOrGeometric;
    double firstNumber;
    double marginOrMulitplex;
    Double[] arrOfSeries = new Double[20];
    double sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        seriesList = (ListView) findViewById(R.id.listSeriesList);
        x1 = (TextView) findViewById(R.id.tvX1);
        d = (TextView) findViewById(R.id.tvD);
        n = (TextView) findViewById(R.id.tvN);
        sn = (TextView) findViewById(R.id.tvSn);

        in = getIntent();
        mathmaticalOrGeometric = in.getStringExtra("mathmaticalOrGeometric");
        firstNumber = in.getDoubleExtra("firstNumber", -1);
        marginOrMulitplex = in.getDoubleExtra("marginOrMulitplex", -1);
        x1.setText(firstNumber + "");
        d.setText(marginOrMulitplex + "");

        if(mathmaticalOrGeometric.equals("geometric"))
        {
            for(int i = 0; i < 20; i++)
            {
                arrOfSeries[i] = firstNumber * Math.pow(marginOrMulitplex, i);
            }
        }
        else
        {
            for(int i = 0; i < 20; i++)
            {
                arrOfSeries[i] = firstNumber + marginOrMulitplex * i;
            }
        }
        adapterForList = new ArrayAdapter<Double>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrOfSeries);
        seriesList.setAdapter(adapterForList);
        seriesList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        n.setText((position + 1) + "");

        if(mathmaticalOrGeometric.equals("geometric"))
        {
            sum = firstNumber * ((Math.pow(marginOrMulitplex, position + 1) - 1) / (marginOrMulitplex - 1));
        }
        else
        {
            sum = ((position + 1) * (firstNumber + (firstNumber + marginOrMulitplex * position))) / 2;
        }
        sn.setText("" + sum);
    }
    public void goToMain(View view)
    {
        finish();
    }
}