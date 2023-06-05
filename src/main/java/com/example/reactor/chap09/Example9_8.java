package com.example.reactor.chap09;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Slf4j
public class Example9_8 {
    public static void main(String[] args) {
        Sinks.Many<Integer> unicateSink = Sinks.many().unicast().onBackpressureBuffer();
        Flux<Integer> fluxView = unicateSink.asFlux();

        unicateSink.emitNext(1, Sinks.EmitFailureHandler.FAIL_FAST);
        unicateSink.emitNext(2, Sinks.EmitFailureHandler.FAIL_FAST);

        fluxView.subscribe(data -> log.info("# Subscriber1 : {}", data));

        unicateSink.emitNext(3, Sinks.EmitFailureHandler.FAIL_FAST);

        //fluxView.subscribe(data -> log.info("# Subscriber2 : {}", data));

    }
}
