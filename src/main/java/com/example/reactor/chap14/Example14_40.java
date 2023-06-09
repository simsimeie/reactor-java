
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

@Slf4j
public class Example14_40 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .just("...", "---", "...")
                .map(code -> transformMorseCode(code))
                .collectList()
                .subscribe(list -> log.info(list.stream().collect(Collectors.joining())));
    }

    private static String transformMorseCode(String code) {
        return SampleData.morseCodeMap.get(code);
    }

}
