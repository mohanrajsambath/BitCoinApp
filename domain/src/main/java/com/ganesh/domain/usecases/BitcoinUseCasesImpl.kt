package com.ganesh.domain.usecases


import com.ganesh.domain.model.BpiDomainModel
import com.ganesh.domain.model.ResultState
import com.ganesh.domain.repository.HistoricalRateRepository

open class BitcoinUseCasesImpl(
    private val repo: HistoricalRateRepository
) : BitCoinUseCases {

    override suspend fun getHistoricalData(currencyName: String): ResultState<BpiDomainModel> {
        return repo.getHistoricalData(currencyName, "2019-12-13", "2019-12-18")
    }

}