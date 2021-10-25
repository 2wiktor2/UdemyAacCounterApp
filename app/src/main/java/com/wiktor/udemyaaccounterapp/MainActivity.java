package com.wiktor.udemyaaccounterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewCount;
    private MainActivityViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new ViewModelProvider(this).get(MainActivityViewModel.class);


        textViewCount = findViewById(R.id.textViewCount);
        Button buttonIncrement = findViewById(R.id.button_increment);
        Button buttonDecrement = findViewById(R.id.button_decrement);
        buttonIncrement.setOnClickListener(this);
        buttonDecrement.setOnClickListener(this);

        textViewCount.setText(String.valueOf(model.getCurrentValue()));
    }


    private void decreaseValue() {
        textViewCount.setText(String.valueOf(model.getDecreaseValue()));
    }

    private void increaseValue() {
        textViewCount.setText(String.valueOf(model.getIncreaseValue()));
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