package com.ganesh.domain.usecases

import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.ResultState


interface CurrencyUseCases {
    suspend fun getCurrencyList(): ResultState<List<CurrencyDomainModel>>
}