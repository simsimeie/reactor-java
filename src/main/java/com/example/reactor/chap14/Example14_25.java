
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class Example14_25 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                // 조건을 만족할 때까지만 take한다. until과 다르게 while은 조건을 만족하지 않은 마지막은 emit하지 않는다.
                .takeWhile(tuple -> tuple.getT2() > 20_000_000)
                .subscribe(tuple -> log.info("# onNext : {}, {}", tuple.getT1(), tuple.getT2()));
    }
}
