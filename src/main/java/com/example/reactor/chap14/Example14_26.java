
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class Example14_26 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                .next()
                .subscribe(tuple -> log.info("# onNext : {}, {}", tuple.getT1(), tuple.getT2()));
    }
}
