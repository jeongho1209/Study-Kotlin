package com.example.kotlin.infrastructure.feign.dto.request

data class GoogleCodeRequest(
        val code: String,
        val clientId: String,
        val clientSecret: String,
        val redirectUri: String,
) {
    val grantType: String = "authorization_code"
}
