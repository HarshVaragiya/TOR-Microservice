package com.example.bookratingservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookRatingServiceApplication

fun main(args: Array<String>) {
    runApplication<BookRatingServiceApplication>(*args)
}
