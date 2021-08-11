package com.example.m27597fuelapp.ui.consumption;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConsumptionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ConsumptionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Consumption Fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}