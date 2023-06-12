package com.example.reactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactorApplication {
    public static void main(String[] args) {
        BlockHound.install();
        SpringApplication.run(ReactorApplication.class, args);
    }
}
