package com.ganesh.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ganesh.data.local.dao.CurrencyDao
import com.ganesh.data.local.entities.CurrencyEntities
import com.ganesh.data.local.entities.RateEntities
import com.ganesh.data.local.dao.RateDao

/**
 * Created by GaneshKumar
 *
 * database
 */
@Database(entities = [CurrencyEntities::class, RateEntities::class], version = 2, exportSchema = false)
abstract class BitCoinDB : RoomDatabase() {
    abstract fun getCurrencyDAO(): CurrencyDao
    abstract fun getRateDAO(): RateDao
}