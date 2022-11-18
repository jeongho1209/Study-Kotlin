package com.example.kotlincode.domain.user.api.dto

data class DomainUserSignUpRequest(
        val accountId: String,
        val password: String,
        val username: String
)
