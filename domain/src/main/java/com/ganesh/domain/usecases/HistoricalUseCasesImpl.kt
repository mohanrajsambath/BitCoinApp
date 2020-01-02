package com.ganesh.domain.usecases


import com.ganesh.domain.model.BpiDomainModel
import com.ganesh.domain.model.ResultState
import com.ganesh.domain.repository.HistoricalRateRepository

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by GaneshKumar
 *
 * HistoricalUseCasesImpl use case implementation
 */
open class HistoricalUseCasesImpl(
    private val repo: HistoricalRateRepository
) : HistoricalUseCases {

    override suspend fun getHistoricalData(currencyName: String): ResultState<BpiDomainModel> {
        return repo.getHistoricalData(currencyName, getDateOn(-14), getDateOn(0))
    }


    fun getDateOn(day: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, day)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        return dateFormat.format(calendar.time)
    }
}