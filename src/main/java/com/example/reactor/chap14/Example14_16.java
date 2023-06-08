
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class Example14_16 {
    public static void main(String[] args) {
        Flux.fromIterable(SampleData.btcTopPricesPerYear)
                .filter(tuple -> tuple.getT2() > 20_000_000)
                .subscribe(data -> log.info(data.getT1() + ":" + data.getT2()));

    }
}
