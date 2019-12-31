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

        if (!connectivity.hasNetworkAccess()) {
            return ResultState.Error<Throwable>(Throwable(Exception("no data"))) as ResultState<BpiDomainModel>
        }

       var r =  currencyNetworkSource.getHostoricalData(currency, startDate, endDate).errorBody()

        print(r)
        print(r)

        val result = currencyNetworkSource.getHostoricalData(currency, startDate, endDate).body()
            .let {
                it?.toDomainModel()
            }


        return ResultState.Success(result) as ResultState<BpiDomainModel>


    }
}