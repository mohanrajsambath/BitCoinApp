package com.ganesh.data.source.remote

import com.ganesh.domain.model.CurrentBpiDomainModel

data class USD(

    val code: String,
    val rate: String,
    val description: String,
    val rate_float: Double
)

data class TimeCurrentPrice(

    val updated: String,
    val updatedISO: String,
    val updateduk: String
)

data class BpiCurrentPriceModel(
    val time: Time,
    val disclaimer: String,
    //val bpi: Bpi
    val bpi: String
)

fun BpiCurrentPriceModel.toDomain(name:String, rate:String): CurrentBpiDomainModel {
    return CurrentBpiDomainModel(name,rate, time.updated)
}



data class CurrenctPrideModel(
    val code: String,
    val rate: String,
    val description: String,
    val rate_float: Double
)