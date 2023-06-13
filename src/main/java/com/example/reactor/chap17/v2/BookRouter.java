package com.example.reactor.chap17.v2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration("bookRouterV2")
public class BookRouter {
    @Bean("routeBookV2")
    public RouterFunction<?> routeBook(BookHandler handler){
        return route()
                .POST("/v2/books", handler::createBook)
                .PATCH("/v2/books/{book-id}", handler::patchBook)
                .GET("/v2/books", handler::getBooks)
                .GET("/v2/books/{book-id}", handler::getBook)
                .build();

    }
}
