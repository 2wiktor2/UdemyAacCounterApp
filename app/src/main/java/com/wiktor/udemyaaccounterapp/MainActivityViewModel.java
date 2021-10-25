package com.wiktor.udemyaaccounterapp;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private int count;

    public int getDecreaseValue() {
        return --count;
    }

    public int getIncreaseValue() {
        return ++count;
    }

    public int getCurrentValue() {
        return count;
    }
}
