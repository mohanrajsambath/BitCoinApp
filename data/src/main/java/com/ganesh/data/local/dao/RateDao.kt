package com.ganesh.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ganesh.data.local.entities.RateEntities

/**
 * Created by GaneshKumar
 *
 * Rate DAO
 */
@Dao
interface RateDao {

    @Insert
    suspend fun insert(entires: RateEntities)

    @Query("DELETE FROM RateTable")
    suspend fun delete()

    @Query("select * from RateTable where currencyName IN (:currencyName)")
    suspend fun getCurrentRate(currencyName:String): RateEntities
}