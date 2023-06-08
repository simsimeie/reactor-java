
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;

import java.util.Map;

@Slf4j
public class Example14_17 {
    public static void main(String[] args) throws InterruptedException {
        Map<SampleData.CovidVaccine, Tuple2<SampleData.CovidVaccine, Integer>> vaccineMap = SampleData.getCovidVaccines();

        Flux.fromIterable(SampleData.coronaVaccineNames)
                .filterWhen(vaccine -> Mono.just(vaccineMap.get(vaccine).getT2() >= 3_000_000))
                .publishOn(Schedulers.parallel())
                .subscribe(data -> log.info("# onNext : {}", data));

        Thread.sleep(1000L);
    }
}
