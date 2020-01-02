package com.ganesh.data.di

import com.ganesh.data.common.Connectivity
import com.ganesh.data.common.ConnectivityImpl
import com.ganesh.data.repository.CurrencyReppositoryImpl
import com.ganesh.data.repository.CurrentRateRepositoryImpl
import com.ganesh.data.repository.HistoricalRateRepositoryImpl
import com.ganesh.data.source.local.source.CurrencyDBSource
import com.ganesh.data.source.local.source.CurrencyDBSourceImpl
import com.ganesh.data.source.local.source.RateDBSource
import com.ganesh.data.source.local.source.RateDBSourceImpl
import com.ganesh.domain.repository.CurrenctRateRepository
import com.ganesh.domain.repository.CurrencyRepository
import com.ganesh.domain.repository.HistoricalRateRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by GaneshKumar
 *
 * modult for repository
 */
val createRepositoryModule = module {

    factory<CurrencyRepository> { CurrencyReppositoryImpl(get(), get(), get()) }

    factory<CurrencyDBSource> { CurrencyDBSourceImpl(get()) }

    factory<RateDBSource> { RateDBSourceImpl(get()) }

    factory<HistoricalRateRepository> { HistoricalRateRepositoryImpl(get(), get()) }

    factory<CurrenctRateRepository> { CurrentRateRepositoryImpl(get(), get(), get()) }

    single<Connectivity> {
        ConnectivityImpl(androidContext())
    }
}