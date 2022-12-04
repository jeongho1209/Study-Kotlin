package com.example.kotlin.infrastructure.feign.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "auth.google")
@ConstructorBinding
data class GoogleFeignProperties(
        val baseUrl: String,
        val clientId: String,
        val clientSecret: String,
        val redirectUri: String
)
