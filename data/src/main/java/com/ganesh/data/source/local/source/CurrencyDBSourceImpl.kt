package com.ganesh.data.source.local.source

import com.ganesh.data.local.dao.CurrencyDao

import com.ganesh.data.mapper.toDomainModel
import com.ganesh.data.mapper.toMapperModel
import com.ganesh.data.remote.model.CurrencyModel

import com.ganesh.domain.model.CurrencyDomainModel


class CurrencyDBSourceImpl constructor(private val currencyDao: CurrencyDao) :
    CurrencyDBSource {

    override suspend fun insert(list: List<CurrencyModel>) {
        currencyDao.deleteCurrencyValues()
        list.map {
            currencyDao.storeCurrentcyVaues(it.toMapperModel())
        }
    }


    override suspend fun getCurrencyList(): List<CurrencyDomainModel> {
        return currencyDao.getCurrencyList().map {
            it.toDomainModel()
        }.toList()
    }

}