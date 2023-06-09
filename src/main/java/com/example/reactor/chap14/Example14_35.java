
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class Example14_35 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .zip(
                        Flux.just(1, 2, 3).delayElements(Duration.ofMillis(300L)),
                        Flux.just(4, 5, 6).delayElements(Duration.ofMillis(500L))
                )
                .subscribe(tuple2 -> log.info("# onNext : {}", tuple2));

        Thread.sleep(2500L);
    }
}
