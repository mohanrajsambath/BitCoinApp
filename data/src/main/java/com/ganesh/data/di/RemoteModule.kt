package com.ganesh.data.di

import com.ganesh.data.common.Connectivity
import com.ganesh.data.common.ConnectivityImpl
import com.ganesh.data.source.local.source.CurrencyDBSource
import com.ganesh.data.source.local.source.CurrencyDBSourceImpl
import com.ganesh.data.source.local.source.RateDBSource
import com.ganesh.data.source.local.source.RateDBSourceImpl
import com.ganesh.data.remote.HttpClient
import com.ganesh.data.repository.HistoricalRateRepositoryImpl
import com.ganesh.data.repository.CurrencyReppositoryImpl
import com.ganesh.data.repository.CurrentRateRepositoryImpl
import com.ganesh.domain.repository.CurrenctRateRepository
import com.ganesh.domain.repository.HistoricalRateRepository
import com.ganesh.domain.repository.CurrencyRepository


import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.converter.moshi.MoshiConverterFactory
/**
 * Created by GaneshKumar
 *
 * module for retrofit
 */

val createRemoteModule = module {

    factory<Interceptor> {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.HEADERS)
    }

    factory { OkHttpClient.Builder().addInterceptor(get()).build() }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://api.coindesk.com/v1/bpi/")
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    factory { get<Retrofit>().create(HttpClient::class.java) }


}