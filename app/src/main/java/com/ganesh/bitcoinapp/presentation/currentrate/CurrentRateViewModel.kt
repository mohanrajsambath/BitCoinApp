package com.ganesh.bitcoinapp.presentation.currentrate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ganesh.bitcoinapp.model.CurrentRateData
import com.ganesh.bitcoinapp.model.toAppModel
import com.ganesh.bitcoinapp.presentation.bitcoin.BitCoinDetailsFragmentDirections
import com.ganesh.common.base.BaseViewModel
import com.ganesh.domain.model.ResultState
import com.ganesh.domain.usecases.CurrentRateUseCases
import kotlinx.coroutines.launch

class CurrentRateViewModel constructor(val bitCoinUseCases:CurrentRateUseCases ) : BaseViewModel() {

    fun currencyDetailsButtonClicked() =
        navigate(BitCoinDetailsFragmentDirections.actionBitcoinToCurrencyListFragment())

   var data: MutableLiveData<CurrentRateData> = MutableLiveData()

    fun getHistoricalData(currencyName :String) {
        showProgressView.value = true

        viewModelScope.launch {

            when (val result = bitCoinUseCases.getCurrentRate(currencyName)) {

                is ResultState.Success -> {
                    data.value  = result.data.toAppModel()
                }

                is ResultState.Error -> {
                    errorMessage.value = result.throwable.message
                }

            }

                 showProgressView.value = false

            }

        }
    }

