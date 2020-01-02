package com.ganesh.data.repository

import com.ganesh.data.common.Connectivity
import com.ganesh.data.mapper.toDomainModel
import com.ganesh.data.remote.HttpClient

import com.ganesh.domain.model.BpiDomainModel
import com.ganesh.domain.model.ResultState
import com.ganesh.domain.repository.HistoricalRateRepository
import java.io.IOException

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
            /**
             * check internet connection
             */
            if (!connectivity.hasNetworkAccess()) {
                return ResultState.Error<Throwable>(Throwable(Exception("No Internet"))) as ResultState<BpiDomainModel>
            }

            var result =
                currencyNetworkSource.getHostoricalData(currency, startDate, endDate)

            // parsing the success result
            if (result.isSuccessful) {
                result.body().let {
                    return ResultState.Success(it?.toDomainModel()) as ResultState<BpiDomainModel>
                }
            }

            //parsing error message
            result.errorBody().let {
                return ResultState.Error<Throwable>(Throwable(Exception(it.toString()))) as ResultState<BpiDomainModel>
            }


        } catch (e: IOException) {
            //return exception details
            return ResultState.Error<Throwable>(Throwable(e)) as ResultState<BpiDomainModel>
        }

    }

}