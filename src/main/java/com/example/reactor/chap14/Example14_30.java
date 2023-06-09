
package com.example.reactor.chap14;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class Example14_30 {
    public static void main(String[] args) throws InterruptedException {
        // flatMap() 내부의 Inner Sequence를 비동기적으로 실행하면 데이터 emit의 순서를 보장하지 않는다.
        Flux
                .range(2, 8)
                .flatMap(dan -> Flux
                        .range(1, 9)
                        .publishOn(Schedulers.parallel())
                        .map(n -> dan + "*" + n + " = " + dan * n))
                .subscribe(log::info);
        Thread.sleep(1000L);
    }
}
