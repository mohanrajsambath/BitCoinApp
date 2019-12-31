package com.ganesh.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ganesh.domain.model.CurrencyDomainModel


@Entity(tableName = "CurrencyTable")
data class CurrencyEntities(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "currencyName") val currencyName: String,
    @ColumnInfo(name = "countryName") val countryName: String
)

