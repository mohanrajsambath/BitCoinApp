package com.ganesh.domain.usecases


import com.ganesh.domain.model.BpiDomainModel
import com.ganesh.domain.model.CurrentBpiDomainModel
import com.ganesh.domain.model.ResultState
import com.ganesh.domain.repository.CurrenctRateRepository
import com.ganesh.domain.repository.HistoricalRateRepository

class CurrentRateUseCasesImpl(
    private val repo: CurrenctRateRepository
) : CurrentRateUseCases {

    override suspend fun getCurrentRate(currencyName: String): ResultState<CurrentBpiDomainModel> {
        return repo.getCurrenctData(currencyName)
    }

}