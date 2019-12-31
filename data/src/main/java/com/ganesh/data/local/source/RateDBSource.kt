package com.ganesh.data.local.source

import com.ganesh.data.local.RateEntities
import com.ganesh.data.remote.model.CurrencyModel
import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.CurrentBpiDomainModel

interface RateDBSource {

    suspend fun insert(list: CurrentBpiDomainModel)

    suspend fun getCurrentRate(currencyName:String): CurrentBpiDomainModel?

}