package com.example.androidunittest;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public String convertToUpperCase(String input) {
        if (input == null) return "";
        return input.toUpperCase();
    }
}