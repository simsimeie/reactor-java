
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class Example14_42 {
    public static void main(String[] args) throws InterruptedException {
        Flux.range(1, 5)
                .doFinally(signalType -> log.info("# doFinally 1 : {}", signalType))
                .doFinally(signalType -> log.info("# doFinally 2 : {}", signalType))
                .doOnNext(data -> log.info("# range > doOnNext(): {}", data))
                .doOnRequest(data -> log.info("# doOnRequest : {}", data))
                .doOnSubscribe(subscription -> log.info("# doOnSubscribe 1"))
                .doFirst(() -> log.info("# doFirst()"))
                .filter(num-> num % 2 == 1)
                .doOnNext(data -> log.info("# filter > doOnNext(): {}",data))
                .doOnComplete(() -> log.info("# doOnComplete()"))
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        log.info("# hookOnNext : {}", value);
                        request(1);
                    }
                });
    }

}
