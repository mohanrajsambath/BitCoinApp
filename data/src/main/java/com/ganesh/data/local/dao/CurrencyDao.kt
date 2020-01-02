package com.ganesh.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ganesh.data.local.entities.CurrencyEntities

/**
 * Created by GaneshKumar
 *
 * Currency DAO
 */

@Dao
interface CurrencyDao {

    @Insert
    suspend fun storeCurrentcyVaues(entires: CurrencyEntities)

    @Query("DELETE FROM CurrencyTable")
    suspend fun deleteCurrencyValues()

    @Query("select * from CurrencyTable")
    suspend fun getCurrencyList(): List<CurrencyEntities>
}