package com.ganesh.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ganesh.domain.model.CurrencyDomainModel


@Entity(tableName = "RateTable")
data class RateEntities(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "rate") val rate: String,
    @ColumnInfo(name = "currencyName") val currencyName: String,
    @ColumnInfo(name = "updateOn") val updatedOn: String
)


