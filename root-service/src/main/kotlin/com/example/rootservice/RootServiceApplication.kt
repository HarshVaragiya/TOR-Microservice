package com.example.rootservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RootServiceApplication

fun main(args: Array<String>) {
    runApplication<RootServiceApplication>(*args)

}
