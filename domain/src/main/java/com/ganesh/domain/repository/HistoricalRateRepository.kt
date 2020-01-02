package com.ganesh.domain.repository

import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.*

/**
 * Created by GaneshKumar
 *
 * Historical data repository
 */
interface HistoricalRateRepository {

    suspend fun getHistoricalData(currency: String, startDate: String, endDate: String):
            ResultState<BpiDomainModel>
}