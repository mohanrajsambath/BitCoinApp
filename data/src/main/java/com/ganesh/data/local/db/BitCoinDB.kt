package com.ganesh.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ganesh.data.local.dao.CurrencyDao
import com.ganesh.data.local.CurrencyEntities
import com.ganesh.data.local.RateEntities
import com.ganesh.data.local.dao.RateDao

@Database(entities = [CurrencyEntities::class, RateEntities::class], version = 2, exportSchema = false)
abstract class BitCoinDB : RoomDatabase() {
    abstract fun getCurrencyDAO(): CurrencyDao
    abstract fun getRateDAO(): RateDao
}