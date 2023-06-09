
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class Example14_22 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .interval(Duration.ofSeconds(1))
                .take(Duration.ofMillis(2500))
                .subscribe(data -> log.info("# onNext : {}", data));

        Thread.sleep(4000L);
    }
}
