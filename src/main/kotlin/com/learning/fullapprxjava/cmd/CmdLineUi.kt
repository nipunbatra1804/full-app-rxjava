package com.learning.fullapprxjava.cmd

import com.learning.fullapprxjava.observer.ConsolePrintObserver
import com.learning.fullapprxjava.service.CoinBaseService
import io.reactivex.rxjava3.core.Observable

import io.reactivex.rxjava3.schedulers.Schedulers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class CmdLineUi : CommandLineRunner {

    @Autowired
    private lateinit var coinBaseService: CoinBaseService

    @Throws(Exception::class)
    override fun run(vararg args: String?) {

        println("Linkedin learning reactive programming with java 8")

        Observable.interval(3000, TimeUnit.MILLISECONDS, Schedulers.io())
            .map{tick -> coinBaseService.getCryptoPrice("BTC-USD")}
            .subscribe(ConsolePrintObserver())

        Observable.interval(3000, TimeUnit.MILLISECONDS, Schedulers.io())
            .map{tick -> coinBaseService.getCryptoPrice("ETH-USD")}
            .subscribe(ConsolePrintObserver())
    }
}
