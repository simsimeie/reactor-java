package com.example.reactor.chap14;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book {
    private String bookName;
    private String authorName;
    private String penName;
    private int price;
    private int stockQuantity;
}