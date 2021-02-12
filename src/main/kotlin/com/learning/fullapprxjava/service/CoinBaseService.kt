package com.learning.fullapprxjava.service

import com.learning.fullapprxjava.model.CoinBaseResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

interface CoinBaseService {
    fun getCryptoPrice(priceName: String): Mono<CoinBaseResponse>;
}

@Service
class CoinBaseServiceImpl(val webClient: WebClient): CoinBaseService {

    override fun getCryptoPrice(priceName: String): Mono<CoinBaseResponse> {
        return webClient
            .get()
            .uri("https://api.coinbase.com/v2/prices/{cryptoName}/buy", priceName)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .flatMap { clientResponse: ClientResponse ->
                clientResponse.bodyToMono(CoinBaseResponse::class.java)

            }
    }
}



