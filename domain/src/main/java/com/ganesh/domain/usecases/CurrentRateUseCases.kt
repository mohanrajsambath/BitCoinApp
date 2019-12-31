package com.ganesh.domain.usecases

import com.ganesh.domain.model.BpiDomainModel
import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.CurrentBpiDomainModel
import com.ganesh.domain.model.ResultState


interface CurrentRateUseCases {
    suspend fun getCurrentRate(currencyName:String): ResultState<CurrentBpiDomainModel>
}