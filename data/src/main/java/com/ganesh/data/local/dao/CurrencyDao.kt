package com.ganesh.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ganesh.data.local.CurrencyEntities


@Dao
interface CurrencyDao {

    @Insert
    suspend fun storeCurrentcyVaues(entires: CurrencyEntities)

    @Query("DELETE FROM CurrencyTable")
    suspend fun deleteCurrencyValues()

    @Query("select * from CurrencyTable")
    suspend fun getCurrencyList(): List<CurrencyEntities>
}