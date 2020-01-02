package com.ganesh.domain.repository

import com.ganesh.domain.model.CurrencyDomainModel
import com.ganesh.domain.model.*

/**
 * Created by GaneshKumar
 *
 * Currency data repository
 */
interface CurrencyRepository {
    suspend fun getCurrencyLitFromCacheOrNetwork(): ResultState<List<CurrencyDomainModel>>
}