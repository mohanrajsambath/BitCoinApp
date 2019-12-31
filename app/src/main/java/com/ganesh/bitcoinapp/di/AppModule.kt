package com.ganesh.bitcoinapp.di

import com.ganesh.bitcoinapp.presentation.SharedViewModel
import com.ganesh.bitcoinapp.presentation.hostoricalrate.HistoricalViewModel
import com.ganesh.bitcoinapp.presentation.currentrate.CurrentRateViewModel
import com.ganesh.bitcoinapp.presentation.currency.CurrencyListAdapter
import com.ganesh.bitcoinapp.presentation.currency.CurrencyViewModel
import com.ganesh.domain.usecases.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


var appModule = module {
    viewModel {
        HistoricalViewModel(get())
    }


    factory {
        CurrencyListAdapter()
    }


}

var sharedModulel = module {
    viewModel {
        SharedViewModel()
    }
}

var currencyModeulel = module {

    val use = single<CurrencyUseCases> {
        CurrencyUseCasesImpl(get())
    }

    single<BitCoinUseCases> { BitcoinUseCasesImpl(get()) }

    viewModel {
        CurrencyViewModel(useCase = get())
    }

}

var currentBitCoinViewMode = module {
    viewModel {
        CurrentRateViewModel(get())
    }

    single<CurrentRateUseCases> {
        CurrentRateUseCasesImpl(get())
    }
}





