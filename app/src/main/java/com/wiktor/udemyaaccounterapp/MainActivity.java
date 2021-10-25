package com.wiktor.udemyaaccounterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewCount;
    private MainActivityViewModel model;
    private LiveData<Integer> countLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        Button buttonIncrement = findViewById(R.id.button_increment);
        Button buttonDecrement = findViewById(R.id.button_decrement);
        buttonIncrement.setOnClickListener(this);
        buttonDecrement.setOnClickListener(this);


        model = new ViewModelProvider(this).get(MainActivityViewModel.class);

        countLiveData = model.getCurrentValue();
        countLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textViewCount.setText(String.valueOf(integer));
            }
        });
    }

    private void decreaseValue() {
        model.getDecreaseValue();
    }

    private void increaseValue() {
        model.getIncreaseValue();
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