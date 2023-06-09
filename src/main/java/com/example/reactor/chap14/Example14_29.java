
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class Example14_29 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .just("Good", "Bad")
                .flatMap(feeling -> Flux.just("Morning", "Afternoon", "Evening").map(time -> feeling + " " + time))
                .subscribe(log::info);
    }
}
