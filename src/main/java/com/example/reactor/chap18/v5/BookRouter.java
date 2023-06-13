package com.example.reactor.chap18.v5;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration("bookRouterV5")
public class BookRouter {
    @Bean
    public RouterFunction<?> routeBookV5(@Qualifier("BookHandlerV5") BookHandler handler) {
        return route()
                .POST("/v5/books", handler::createBook)
                .PATCH("/v5/books/{book-id}", handler::updateBook)
                .GET("/v5/books", handler::getBooks)
                .GET("/v5/books/{book-id}", handler::getBook)
                .build();
    }
}