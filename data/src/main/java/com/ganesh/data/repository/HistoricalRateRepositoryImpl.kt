package com.ganesh.data.repository

import com.ganesh.data.common.Connectivity
import com.ganesh.data.mapper.toDomainModel
import com.ganesh.data.remote.source.HttpClient

import com.ganesh.domain.model.BpiDomainModel
import com.ganesh.domain.model.ResultState
import com.ganesh.domain.repository.HistoricalRateRepository

@Suppress("UNCHECKED_CAST")
class HistoricalRateRepositoryImpl(
    private val currencyNetworkSource: HttpClient,
    private val connectivity: Connectivity
) : HistoricalRateRepository {

    override suspend fun getHistoricalData(
        currency: String,
        startDate: String,
        endDate: String
    ): ResultState<BpiDomainModel> {

        try {

            if (!connectivity.hasNetworkAccess()) {
                return ResultState.Error<Throwable>(Throwable(Exception("No Internet"))) as ResultState<BpiDomainModel>
            }

            var result = currencyNetworkSource.getHostoricalData(currency, startDate, endDate)

            result.errorBody()?.let {
                return ResultState.Error<Throwable>(Throwable(Exception(it.toString()))) as ResultState<BpiDomainModel>
            }

            result.body().let {
                return ResultState.Success(it?.toDomainModel()) as ResultState<BpiDomainModel>
            }
        } catch (e: Exception) {
            return ResultState.Error<Throwable>(Throwable(e)) as ResultState<BpiDomainModel>
        }

    }
}