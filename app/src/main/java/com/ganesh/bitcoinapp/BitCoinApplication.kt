package com.ganesh.bitcoinapp

import android.app.Application
import com.ganesh.bitcoinapp.di.*

import com.ganesh.data.di.createRemoteModule

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class BitCoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()



        startKoin {
            androidContext(this@BitCoinApplication)
            modules(
                listOf(
                    dbModule,
                    createRemoteModule,
                    appModule,
                    sharedModulel,
                    currencyModeulel,
                    currentBitCoinViewMode
                )
            )
        }
    }
}