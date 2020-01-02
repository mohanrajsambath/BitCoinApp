package com.ganesh.bitcoinapp.presentation.hostoricalrate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ganesh.bitcoinapp.model.BitCoinHistoricalData
import com.ganesh.bitcoinapp.presentation.bitcoinhome.BitCoinHomFragmentDirections

import com.ganesh.common.base.BaseViewModel
import com.ganesh.domain.model.ResultState
import com.ganesh.domain.usecases.HistoricalUseCases
import kotlinx.coroutines.launch

open
class HistoricalViewModel constructor(private val bitCoinUseCases: HistoricalUseCases) :
    BaseViewModel() {

    fun currencyDetailsButtonClicked() =
        navigate(BitCoinHomFragmentDirections.actionBitcoinToCurrencyListFragment())

    var data: MutableLiveData<List<BitCoinHistoricalData>> = MutableLiveData()

    /**
     * get Historical data from domain layer
     *
     * @param currencyName
     */
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

    /**
     * handling result of historical data
     *
     * @param result
     */
    fun handlerSuccess(result: List<BitCoinHistoricalData>?) {
        result?.let {

            val sortedList = result.sortedByDescending {
                it.date
            }

            data.value = sortedList
        }
    }

    /**
     * handling error message
     *
     * @param result
     */
    fun handlerFailuer(result: String?) {
        result.let {
            errorMessage.value = result
        }

    }
}