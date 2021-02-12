package com.learning.fullapprxjava.observer

import com.learning.fullapprxjava.model.CoinBaseResponse
import io.reactivex.rxjava3.observers.DefaultObserver
import reactor.core.publisher.Mono
import java.time.LocalDateTime

class ConsolePrintObserver : DefaultObserver<Any>() {
    override fun onNext(o: Any?) {
        val responseMono = o as Mono<CoinBaseResponse>

        responseMono.subscribe { coinBaseResponse ->
            println("[${LocalDateTime.now()}-${coinBaseResponse.data!!.base}] BuyPrice:${coinBaseResponse.data!!.amount} :${coinBaseResponse.data!!.currency}")
        }

    }

    override fun onError(e: Throwable?) {
        println(e!!.message)
    }

    override fun onComplete() {
        println("Complete")
    }

}
