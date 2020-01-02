package com.ganesh.domain.usecases

import com.ganesh.domain.model.BpiDomainModel
import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.ResultState

/**
 * Created by GaneshKumar
 *
 * HistoricalUseCases bitcoin data use case
 */
interface HistoricalUseCases {
    suspend fun getHistoricalData(currencyName:String): ResultState<BpiDomainModel>
}