package com.ganesh.domain.usecases


import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.ResultState
import com.ganesh.domain.repository.CurrencyRepository
import io.reactivex.Scheduler

class CurrencyUseCasesImpl(
    private val repo: CurrencyRepository
    ) : CurrencyUseCases {


    override suspend fun getCurrencyList(): ResultState<List<CurrencyDomainModel>> {
        return repo
            .getCurrencyLitFromCacheOrNetwork()

    }

}