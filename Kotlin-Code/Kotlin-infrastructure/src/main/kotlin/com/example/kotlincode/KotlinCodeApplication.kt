package com.example.kotlincode

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class KotlinCodeApplication

fun main(args: Array<String>) {
    runApplication<KotlinCodeApplication>(*args)

}
