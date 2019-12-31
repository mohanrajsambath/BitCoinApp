package com.ganesh.data.repository


import com.ganesh.data.common.Connectivity
import com.ganesh.data.mapper.toDoaminModel
import com.ganesh.data.local.source.CurrencyDBSource
import com.ganesh.data.remote.source.HttpClient
import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.ResultState
import com.ganesh.domain.repository.CurrencyRepository


@Suppress("UNCHECKED_CAST")
class CurrencyReppositoryImpl constructor(
    private val currencyNetworkSource: HttpClient,
    private val currencyDBSource: CurrencyDBSource,
    private val connectivity: Connectivity
) : CurrencyRepository {

    override
    suspend fun getCurrencyLitFromCacheOrNetwork(): ResultState<List<CurrencyDomainModel>> {
        return if (connectivity.hasNetworkAccess()) {
            getDataFromNetwork()
        } else return getDataFromLocal()
    }

    private suspend fun getDataFromNetwork(): ResultState<List<CurrencyDomainModel>> {

        val result = currencyNetworkSource.getCurrencyList()
            .body()?.let {
                it.let {
                    currencyDBSource.insert(it)
                      it.map { model ->
                        model.toDoaminModel()
                    }.toMutableList()
                }
            }

        return ResultState.Success(result) as ResultState<List<CurrencyDomainModel>>
    }

    private suspend fun getDataFromLocal(): ResultState<List<CurrencyDomainModel>> {
        val result = currencyDBSource.getCurrencyList()

        result.let {
            return if (it.isNotEmpty())
                ResultState.Success(result)
            else {
                return ResultState.Error<Throwable>(Throwable(Exception("no data"))) as ResultState<List<CurrencyDomainModel>>
            }
        }


    }

}



