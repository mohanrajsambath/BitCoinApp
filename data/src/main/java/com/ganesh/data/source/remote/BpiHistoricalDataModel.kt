package com.ganesh.data.source.remote

data class BpiHistoricalOuterModel(
    // val bpi: BpiHistoricalDataModel,
 var bpi: Map<String, Double>,
    val disclaimer: String,
    val time: Time
)



data class Time(
    val updated: String,
    val updatedISO: String
)