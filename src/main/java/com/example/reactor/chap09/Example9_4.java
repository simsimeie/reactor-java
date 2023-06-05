package com.example.reactor.chap09;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
@Slf4j
public class Example9_4 {
    public static void main(String[] args) {
        Sinks.One<String> sinkOne = Sinks.one();
        Mono<String> mono = sinkOne.asMono();

        sinkOne.emitValue("Hello Reactor", Sinks.EmitFailureHandler.FAIL_FAST);
        //sinkOne.emitValue("Hi Reactor", Sinks.EmitFailureHandler.FAIL_FAST);

        mono.subscribe(data -> log.info("# Subscriber1 : {}", data));
        mono.subscribe(data -> log.info("# Subscriber2 : {}", data));

    }
}
