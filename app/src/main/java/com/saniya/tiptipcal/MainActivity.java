package com.saniya.tiptipcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText bill;
    TextView percentage;
    SeekBar barbar;
    TextView tip;
    TextView total;
    TextView openion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bill = findViewById(R.id.base);
        percentage = findViewById(R.id.perce);
        barbar = findViewById(R.id.sekb);
        tip = findViewById(R.id.tex5);
        openion=findViewById(R.id.tex6);
        total = findViewById(R.id.tex4);
        barbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int percent= progress;
                percentage.setText(String.valueOf(percent)+"%");
                calculate();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        bill.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculate();
            }
        });
    }
    private void calculate()
    {
            double amount = Double.parseDouble(bill.getText().toString());
            int percent = barbar.getProgress();
            double tipes = amount*percent/100.0;
            double totals = amount+tipes;
            tip.setText(String.valueOf(tipes));
            total.setText(String.valueOf(totals));
            if(percent<10){
                openion.setText(String.valueOf("poor i dont like"));

            }
            else if(percent<30){
                openion.setText(String.valueOf("nice performance"));
            }
            else if(percent<50)
            {
                openion.setText(String.valueOf("good performance"));
            }
            else if(percent<70)
            {
                openion.setText(String.valueOf("amazing performance"));
            }
            else{
                openion.setText(String.valueOf("best performance"));
            }
        }
    }
