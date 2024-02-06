package com.example.reactivekotlinapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveKotlinAppApplication

fun main(args: Array<String>) {
    runApplication<ReactiveKotlinAppApplication>(*args)
}
