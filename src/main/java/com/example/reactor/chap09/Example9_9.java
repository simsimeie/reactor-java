package com.example.reactor.chap09;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Slf4j
public class Example9_9 {
    public static void main(String[] args) {
        Sinks.Many<Integer> multicateSink = Sinks.many().multicast().onBackpressureBuffer();
        Flux<Integer> fluxView = multicateSink.asFlux();

        multicateSink.emitNext(1, Sinks.EmitFailureHandler.FAIL_FAST);
        multicateSink.emitNext(2, Sinks.EmitFailureHandler.FAIL_FAST);

        fluxView.subscribe(data -> log.info("# Subscriber1 : {}", data));
        fluxView.subscribe(data -> log.info("# Subscriber2 : {}", data));


        multicateSink.emitNext(3, Sinks.EmitFailureHandler.FAIL_FAST);


    }
}
