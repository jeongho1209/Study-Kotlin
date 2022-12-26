package com.kotlin.good.global.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class SecurityProperty(
    val secretKey: String,
    val accessExp: Long,
    val refreshExp: Long
)