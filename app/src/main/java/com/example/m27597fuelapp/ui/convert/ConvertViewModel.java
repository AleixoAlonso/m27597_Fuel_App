package com.example.m27597fuelapp.ui.convert;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConvertViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ConvertViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}