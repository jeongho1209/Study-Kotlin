package com.kotlin.good

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GoodApplication

fun main(args: Array<String>) {
    runApplication<GoodApplication>(*args)
}
