package com.example.reactor.chap13;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

import java.time.Duration;

public class Example13_8 {
    @Test
    public void getCOVID19CountTest(){
        StepVerifier
                .withVirtualTime(() -> TimeBasedTestExample.getCOVID19Count(
                        Flux.interval(Duration.ofMinutes(1)).take(1)
                ))
                .expectSubscription()
                .expectNextCount(11)
                .expectComplete()
                .verify(Duration.ofSeconds(3));
    }
}
