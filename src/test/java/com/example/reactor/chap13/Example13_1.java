package com.example.reactor.chap13;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Example13_1 {
    @Test
    public void sayHelloReactorTest() {
        StepVerifier
                .create(Mono.just("Hello Reactor"))
                .expectNext("Hello Reactor")
                .expectComplete()
                .verify();
    }
}
