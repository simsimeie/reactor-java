package com.example.reactor.chap06;

import reactor.core.publisher.Flux;

public class Example6_7 {
    public static void main(String[] args) {
        Flux.concat(
                        Flux.just("Mercury", "Venus", "Earth"),
                        Flux.just("Mars", "Jupiter", "Saturn"),
                        Flux.just("Uranus", "Neptune", "Pluto")
                ).collectList()
                .subscribe(planets -> System.out.println(planets));
    }
}
