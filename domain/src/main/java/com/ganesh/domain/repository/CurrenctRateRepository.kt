package com.ganesh.domain.repository

import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.*


interface CurrenctRateRepository {
    suspend fun getCurrenctData(currency: String):
            ResultState<CurrentBpiDomainModel>
}