package com.ganesh.bitcoinapp.presentation.hostoricalrate


import com.ganesh.bitcoinapp.BaseTest
import com.ganesh.domain.model.BpiDomainModel
import com.ganesh.domain.model.ResultState
import com.ganesh.domain.usecases.HistoricalUseCases
import com.nhaarman.mockito_kotlin.verify
import kotlinx.coroutines.runBlocking

import org.junit.Before
import org.junit.Test

import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


class HistoricalViewModelTest : BaseTest() {

    @Mock
    private lateinit var usecase: HistoricalUseCases
    @InjectMocks
    private lateinit var historicalViewModel: HistoricalViewModel
    private lateinit var spyViewModel: HistoricalViewModel

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        historicalViewModel = HistoricalViewModel(usecase)
        spyViewModel = spy(historicalViewModel)
    }



    @Test
    fun getHistoricalData_validInput_happyCase() {

        val map: Map<String, Double> = HashMap()

        val result = ResultState.Success(BpiDomainModel(map))

        runBlocking {
            `when`(usecase.getHistoricalData("EUR")).thenReturn(result)
            spyViewModel.getHistoricalData("EUR")
            verify(spyViewModel).handlerSuccess(listOf())
        }

    }


}