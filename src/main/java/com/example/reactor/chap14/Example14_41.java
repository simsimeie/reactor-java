
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

@Slf4j
public class Example14_41 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .range(0, 26)
                .collectMap(key -> SampleData.morseCodes[key],
                        value -> transformToLetter(value))
                .subscribe(map -> log.info("# onNext : {}", map));
    }

    private static String transformToLetter(Integer value) {
        return Character.toString((char) ('a' + value));
    }


}
