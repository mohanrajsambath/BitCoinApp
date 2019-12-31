package com.ganesh.data.repository

import com.ganesh.data.common.Connectivity
import com.ganesh.data.local.source.RateDBSource
import com.ganesh.data.remote.source.HttpClient
import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.CurrentBpiDomainModel
import com.ganesh.domain.model.ResultState
import com.ganesh.domain.repository.CurrenctRateRepository


@Suppress("UNCHECKED_CAST")
class CurrentRateRepositoryImpl(
    private val rateDBSource: RateDBSource,
    private val currencyNetworkSource: HttpClient,
    private val connectivity: Connectivity
) : CurrenctRateRepository {

    override suspend fun getCurrenctData(
        currency: String

    ): ResultState<CurrentBpiDomainModel> {

        if (connectivity.hasNetworkAccess()) {
            return fromNetwork(currency)
        } else {
            return fromLocal(currency)
        }

    }


    suspend fun fromNetwork(currency: String): ResultState<CurrentBpiDomainModel> {
        val model = CurrentBpiDomainModel(currency, "", "")

        currencyNetworkSource.getCurrentData(currency).body()
            ?.let {

                it.getAsJsonObject("bpi").apply {
                    model.amount = getAsJsonObject(currency).get("rate").asString
                }
                it.getAsJsonObject("time").apply {
                    model.updatedGMTTime = get("updated").asString
                }


            }

        rateDBSource.insert(model)

        return ResultState.Success(model)
    }


    suspend fun fromLocal(currency: String): ResultState<CurrentBpiDomainModel> {
        val result = rateDBSource.getCurrentRate(currency)

        result?.let {
            return ResultState.Success(result)
        }

        return ResultState.Error<Throwable>(Throwable(Exception("no data"))) as ResultState<CurrentBpiDomainModel>
    }
}