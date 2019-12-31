package com.ganesh.domain.usecases

import com.ganesh.domain.model.BpiDomainModel
import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.ResultState


interface BitCoinUseCases {
    suspend fun getHistoricalData(currencyName:String): ResultState<BpiDomainModel>
}