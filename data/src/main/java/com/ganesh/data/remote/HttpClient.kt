package com.ganesh.data.remote

import com.ganesh.data.source.remote.BpiHistoricalOuterModel
import com.ganesh.data.remote.model.CurrencyModel
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HttpClient {
    @GET("supported-currencies.json")
    suspend fun getCurrencyList(): Response<List<CurrencyModel>>

    @GET("historical/close.json?")
    suspend fun getHostoricalData(
        @Query("currency") currency: String,
        @Query("start") startDate: String,
        @Query("end") endDate: String
    ): Response<BpiHistoricalOuterModel>

    @GET("currentprice/{currency}.json")
    suspend fun getCurrentData(
        @Path("currency") currency: String
    ): Response<JsonObject>


}