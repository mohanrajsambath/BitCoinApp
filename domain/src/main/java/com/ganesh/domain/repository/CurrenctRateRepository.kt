package com.ganesh.domain.repository

import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.*

/**
 * Created by GaneshKumar
 *
 * Current bitcoin data repository
 */
interface CurrenctRateRepository {
    suspend fun getCurrenctData(currency: String):
            ResultState<CurrentBpiDomainModel>
}