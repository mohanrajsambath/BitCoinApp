package com.ganesh.bitcoinapp.model


import com.ganesh.domain.model.CurrencyDomainModel

data class CurrencyData(var currnecyName: String, var countryName: String)


fun CurrencyDomainModel.toPresenterModel(): CurrencyData {
    return CurrencyData(currencyName, countryName)
}

