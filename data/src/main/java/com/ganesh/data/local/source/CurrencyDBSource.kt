package com.ganesh.data.local.source

import com.ganesh.data.remote.model.CurrencyModel
import com.ganesh.domain.model.CurrencyDomainModel

interface CurrencyDBSource {

    suspend fun insert(list: List<CurrencyModel>)

    suspend fun getCurrencyList(): List<CurrencyDomainModel>

}