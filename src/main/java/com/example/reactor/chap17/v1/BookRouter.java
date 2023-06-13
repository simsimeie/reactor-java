package com.example.reactor.chap17.v1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration("bookRouterV1")
public class BookRouter {
    @Bean("routeBookV1")
    public RouterFunction<?> routeBook(BookHandler handler){
        return route()
                .POST("/v1/books", handler::createBook)
                .PATCH("/v1/books/{book-id}", handler::updateBook)
                .GET("/v1/books", handler::getBooks)
                .GET("/v1/books/{book-id}", handler::getBook)
                .build();

    }
}
