package com.ganesh.bitcoinapp.presentation.hostoricalrate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ganesh.bitcoinapp.model.BitCoinHistoricalData
import com.ganesh.bitcoinapp.presentation.bitcoin.BitCoinDetailsFragmentDirections
import com.ganesh.common.base.BaseViewModel
import com.ganesh.domain.model.ResultState
import com.ganesh.domain.usecases.BitCoinUseCases
import kotlinx.coroutines.launch

open
class HistoricalViewModel constructor(private val bitCoinUseCases: BitCoinUseCases) :
    BaseViewModel() {

    fun currencyDetailsButtonClicked() =
        navigate(BitCoinDetailsFragmentDirections.actionBitcoinToCurrencyListFragment())

    var data: MutableLiveData<List<BitCoinHistoricalData>> = MutableLiveData()

    fun getHistoricalData(currencyName: String) {
        showProgressView.value = true

        viewModelScope.launch {

            when (val result = bitCoinUseCases.getHistoricalData(currencyName)) {

                is ResultState.Success -> {
                    handlerSuccess(result.data.dataMap.map {
                        BitCoinHistoricalData(it.key, it.value.toString())
                    })
                }

                is ResultState.Error -> {
                    handlerFailuer(result.throwable.message)
                }

            }

            showProgressView.value = false
        }


    }

    fun handlerSuccess(result: List<BitCoinHistoricalData>?) {
        result?.let {
            data.value = result
        }
    }

    fun handlerFailuer(result: String?) {
        result.let {
            errorMessage.value = result
        }

    }
}