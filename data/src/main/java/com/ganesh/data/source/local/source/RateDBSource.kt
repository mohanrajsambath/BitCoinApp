package com.ganesh.data.source.local.source

import com.ganesh.domain.model.CurrentBpiDomainModel

interface RateDBSource {

    suspend fun insert(list: CurrentBpiDomainModel)

    suspend fun getCurrentRate(currencyName:String): CurrentBpiDomainModel?

}