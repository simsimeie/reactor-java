
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class Example14_24 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                // 조건이 true가 될 때까지 take한다. until은 조건을 만족하는 마지막 결과도 emit 한다.
                .takeUntil(tuple -> tuple.getT2() > 20_000_000)
                .subscribe(tuple -> log.info("# onNext : {}, {}", tuple.getT1(), tuple.getT2()));
    }
}
