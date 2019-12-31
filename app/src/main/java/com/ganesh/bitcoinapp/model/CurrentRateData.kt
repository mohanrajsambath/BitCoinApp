package com.ganesh.bitcoinapp.model

import com.ganesh.domain.model.CurrentBpiDomainModel

data class CurrentRateData(val currencyName: String, val rate: String, val updateOn: String)

fun CurrentBpiDomainModel.toAppModel(): CurrentRateData {
    return CurrentRateData(currencyName, amount, updatedGMTTime)
}