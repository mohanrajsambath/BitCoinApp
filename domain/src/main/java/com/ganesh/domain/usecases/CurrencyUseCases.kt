package com.ganesh.domain.usecases

import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.ResultState

/**
 * Created by GaneshKumar
 *
 * Currency data use case
 */
interface CurrencyUseCases {
    suspend fun getCurrencyList(): ResultState<List<CurrencyDomainModel>>
}