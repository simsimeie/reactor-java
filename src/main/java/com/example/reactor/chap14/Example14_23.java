
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class Example14_23 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                .takeLast(2)
                .subscribe(tuple -> log.info("# onNext : {}, {}", tuple.getT1(), tuple.getT2()));
    }
}
