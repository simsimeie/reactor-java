
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class Example14_20 {
    public static void main(String[] args) throws InterruptedException {
        Flux.
                fromIterable(SampleData.btcTopPricesPerYear)
                .filter(tuple -> tuple.getT2() >= 20_000_000)
                .skip(2)
                // 3개 중 2개 스킵
                .subscribe(tuple -> log.info("{}, {}", tuple.getT1(), tuple.getT2()));

    }
}
