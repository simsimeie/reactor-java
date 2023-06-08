
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class Example14_15 {
    public static void main(String[] args) {
        Flux.range(1, 20)
                .filter(num -> num % 2 != 0)
                .subscribe(data -> log.info("# onNext : {}", data));

    }
}
