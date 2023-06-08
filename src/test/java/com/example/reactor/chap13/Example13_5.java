package com.example.reactor.chap13;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

public class Example13_5 {
    @Test
    public void takeNumberTest(){
        Flux<Integer> source = Flux.range(0, 1000);
        StepVerifier.create(GeneralTestExample.takeNumber(source, 500), StepVerifierOptions.create().scenarioName("Verify from 0 to 499"))
                .expectSubscription()
                .expectNext(0)
                .expectNextCount(498)
                .expectNext(499)
                .expectComplete()
                .verify();
    }
}
