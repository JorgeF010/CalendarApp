package com.example.calendarapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        // add something here for txt on the home fragment
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}