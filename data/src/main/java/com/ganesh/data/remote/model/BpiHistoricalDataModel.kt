package com.ganesh.data.remote.model

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