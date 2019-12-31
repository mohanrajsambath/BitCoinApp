package com.ganesh.bitcoinapp.di

import androidx.room.Room
import com.ganesh.data.local.db.BitCoinDB
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


var dbModule = module(override = true) {


    single {
        Room.databaseBuilder(androidContext(), BitCoinDB::class.java, "BitCoinDB")
            .allowMainThreadQueries().build()
    }

    single {
        get<BitCoinDB>().getCurrencyDAO()

    }
    single {
        get<BitCoinDB>().getRateDAO()
    }

}

