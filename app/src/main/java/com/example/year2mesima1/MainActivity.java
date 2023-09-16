package com.example.year2mesima1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton geometric;
    RadioButton mathmatical;
    Button submit;
    EditText firstNumber;
    EditText marginOrMulitplex;
    String firstNumberSTR;
    String marginOrMulitplexSTR;
    String mathmaticalOrGeometric;
    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geometric = (RadioButton) findViewById(R.id.rbGeometric);
        mathmatical = (RadioButton) findViewById(R.id.rbMathmatical);

        submit = (Button) findViewById(R.id.btn_submit);

        firstNumber = (EditText) findViewById(R.id.editTextFirstNumber);
        marginOrMulitplex = (EditText) findViewById(R.id.editTextMarginOrMulitplex);
    }

    public void buttonOnClick(View view)
    {
        // gets the input from the user
        firstNumberSTR = firstNumber.getText().toString();
        marginOrMulitplexSTR = marginOrMulitplex.getText().toString();

        if ((geometric.isChecked() || mathmatical.isChecked()) && (!firstNumberSTR.equals("")) && (!marginOrMulitplexSTR.equals("")))
        {
            in = new Intent(this, MainActivity2.class);

            // checks what button is pressed
            if(geometric.isChecked())
                mathmaticalOrGeometric = "geometric";
            else
                mathmaticalOrGeometric = "mathmatical";

            // loading data to the intent
            in.putExtra("mathmaticalOrGeometric", mathmaticalOrGeometric);
            in.putExtra("firstNumber", Double.parseDouble(firstNumberSTR));
            in.putExtra("marginOrMulitplex", Double.parseDouble(marginOrMulitplexSTR));
            startActivity(in);
        }
    }
}


