package com.example.reactor.chap16.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service("bookServiceV2")
@RequiredArgsConstructor
public class BookService {
    private final BookMapper mapper;

    public Mono<Book> createBook(Mono<BookDto.Post> book) {
        // not implement business logic;
        return book.flatMap(post -> Mono.just(mapper.bookPostToBook(post)));
    }

    public Mono<Book> updateBook(final long bookId, Mono<BookDto.Patch> book) {
        // not implement business logic;
        return book.flatMap(patch -> {
            patch.setBookId(bookId);
            return Mono.just(mapper.bookPatchToBook(patch));
        });
    }

    public Mono<Book> findBook(long bookId) {
        return Mono.just(
                new Book(bookId,
                        "Java 고급",
                        "Advanced Java",
                        "Kevin",
                        "111-11-1111-111-1",
                        "Java 중급 프로그래밍 마스터",
                        "2022-03-22",
                        LocalDateTime.now(),
                        LocalDateTime.now())
        );
    }
}



