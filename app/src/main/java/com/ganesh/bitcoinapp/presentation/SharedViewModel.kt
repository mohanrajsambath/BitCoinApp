package com.ganesh.bitcoinapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private var currencyName: MutableLiveData<String> = MutableLiveData()
    fun get() = currencyName

    fun setCurrencyName (name:String) {
        currencyName.value = name
    }
}