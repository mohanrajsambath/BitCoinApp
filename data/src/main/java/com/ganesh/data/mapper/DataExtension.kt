package com.ganesh.data.mapper

import com.ganesh.data.local.entities.CurrencyEntities
import com.ganesh.data.local.entities.RateEntities

import com.ganesh.data.source.remote.BpiHistoricalOuterModel
import com.ganesh.data.remote.model.CurrencyModel
import com.ganesh.domain.model.BpiDomainModel
import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.CurrentBpiDomainModel

fun CurrencyModel.toDoaminModel(): CurrencyDomainModel {
    return CurrencyDomainModel(currency, country)
}


fun CurrencyModel.toMapperModel(): CurrencyEntities {
    return CurrencyEntities(0, currency, country)
}

fun CurrencyEntities.toDomainModel(): CurrencyDomainModel {
    return CurrencyDomainModel(currencyName, countryName)
}

fun BpiHistoricalOuterModel.toDomainModel(): BpiDomainModel {
    return BpiDomainModel(bpi)
}

fun CurrentBpiDomainModel.toMapperModel(): RateEntities {
    return RateEntities(
        0,
        amount,
        currencyName,
        updatedGMTTime
    )
}

fun RateEntities.toDomainModel():CurrentBpiDomainModel{
    return CurrentBpiDomainModel(currencyName,rate,updatedOn)
}