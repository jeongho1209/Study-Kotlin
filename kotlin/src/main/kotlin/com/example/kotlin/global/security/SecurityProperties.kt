package com.example.kotlin.global.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.util.*

@ConfigurationProperties(prefix = "jwt")
@ConstructorBinding
class SecurityProperties(
        accessExp: Long,
        refreshExp: Long,
        secretKey: String
) {
    val accessExp = accessExp * 1000
    val refreshExp = refreshExp * 1000
    val secretKey = Base64.getEncoder().encodeToString(secretKey.toByteArray())!!

}