package com.ganesh.data.source.local.source

import com.ganesh.data.local.dao.RateDao

import com.ganesh.data.mapper.toDomainModel
import com.ganesh.data.mapper.toMapperModel

import com.ganesh.domain.model.CurrentBpiDomainModel


inline fun <T : Any, R> whenNotNull(input: T?, callback: (T) -> R): R? {
    return input?.let(callback)
}

class RateDBSourceImpl constructor(private val rateDao: RateDao) :
    RateDBSource {

    override suspend fun insert(model: CurrentBpiDomainModel) {
        rateDao.delete()
        rateDao.insert(model.toMapperModel())
    }

    override suspend fun getCurrentRate(currencyName: String): CurrentBpiDomainModel? {

        var result: CurrentBpiDomainModel? = null

        whenNotNull(rateDao.getCurrentRate(currencyName), {
            result = it.toDomainModel()

        })

        return result

    }
}


