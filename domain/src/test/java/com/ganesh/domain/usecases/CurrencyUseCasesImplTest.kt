package com.ganesh.domain.usecases

import com.ganesh.domain.repository.CurrencyRepository
import org.junit.Assert.*
import org.junit.Test
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.CompletableFuture

class CurrencyUseCasesImplTest {


    @Test
    fun getCurrencyList_validInput_success() {

        // given
        val model = (CurrencyModel("12", "13"))

        val repo = mock<CurrencyRepository> {

            on {
                getCurrencyLitFromCacheOrNetwork()
            } doReturn
                    Single.just(listOf(model))
        }


        val useCases = CurrencyUseCasesImpl(repo, Schedulers.single(), Schedulers.single())
        val future = CompletableFuture<List<CurrencyModel>>()
        val exceptionFuture = CompletableFuture<Throwable>()

        // when
        useCases.getCurrencyList({
            future.complete(it)
        }, {
            exceptionFuture.complete(it)
        })

        //then
        assertEquals(future.get(), listOf(model))
        assert(!exceptionFuture.isDone)

    }

    @Test
    fun getCurrencyList_execption_failure() {
        val exception = RuntimeException("Some error")

        val repo = mock<CurrencyRepository> {
            on {
                getCurrencyLitFromCacheOrNetwork()
            } doReturn
                    Single.error(exception)
        }

        val exceptionFuture = CompletableFuture<Throwable>()

        val useCases = CurrencyUseCasesImpl(repo, Schedulers.single(), Schedulers.single())

        useCases.getCurrencyList({

        },{
            exceptionFuture.complete(it)
        })

        assertEquals(exceptionFuture.get(), exception)
       // assert(exceptionFuture.isDone)
    }


}