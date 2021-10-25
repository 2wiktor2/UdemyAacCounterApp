package com.wiktor.udemyaaccounterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewCount;
    private Button buttonIncrement;
    private Button buttonDecrement;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewCount = findViewById(R.id.textViewCount);
        buttonIncrement = findViewById(R.id.button_increment);
        buttonDecrement = findViewById(R.id.button_decrement);
        buttonIncrement.setOnClickListener(this);
        buttonDecrement.setOnClickListener(this);
    }

    private void decreaseValue() {
        count--;
        textViewCount.setText(String.valueOf(count));
    }

    private void increaseValue() {
        count++;
        textViewCount.setText(String.valueOf(count));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_decrement:
                decreaseValue();
                break;
            case R.id.button_increment:
                increaseValue();
                break;
        }
    }
}