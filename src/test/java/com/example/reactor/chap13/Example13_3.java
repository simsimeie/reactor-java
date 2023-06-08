package com.example.reactor.chap13;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class Example13_3 {
    @Test
    public void sayHelloTest(){
        StepVerifier
                .create(GeneralTestExample.sayHello())
                .expectSubscription()
                .as("# expect subscription")
                .expectNext("Hello")
                .as("# expect Hello")
                .expectNext("Reactor")
                .as("# expect Reactor")
                .verifyComplete();
    }
}
