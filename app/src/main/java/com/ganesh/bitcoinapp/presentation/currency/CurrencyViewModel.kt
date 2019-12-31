package com.ganesh.bitcoinapp.presentation.currency

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ganesh.bitcoinapp.model.CurrencyData
import com.ganesh.bitcoinapp.model.toPresenterModel
import com.ganesh.common.base.BaseViewModel
import com.ganesh.domain.model.ResultState
import com.ganesh.domain.usecases.CurrencyUseCases
import kotlinx.coroutines.launch

class CurrencyViewModel constructor(val useCase: CurrencyUseCases) :
    BaseViewModel() {

    private var currencyLiveData: MutableLiveData<List<CurrencyData>> = MutableLiveData()
    fun currencyData() = currencyLiveData

    fun getCurrencyList() {
        showProgressView.value = true

            viewModelScope.launch {

                when (val result = useCase.getCurrencyList()) {
                is ResultState.Success -> {
                    val data = result.data.map {
                        it.toPresenterModel()
                    }.toList()
                    currencyLiveData.value = data
                }
                is ResultState.Error -> {
                    errorMessage.value = result.throwable.message
                }

            }

            showProgressView.value = false

        }


    }


}