package com.example.kotlin.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
        val secretKey: String,
        val accessExp: Long
) {

    companion object {
        const val ACCESS_KEY = "access"
        const val HEADER = "Authorization"
        const val PREFIX = "Bearer "
    }

}