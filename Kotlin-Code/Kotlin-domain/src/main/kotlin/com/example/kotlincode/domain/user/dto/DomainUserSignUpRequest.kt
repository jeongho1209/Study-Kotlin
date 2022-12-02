package com.example.kotlincode.domain.user.dto

data class DomainUserSignUpRequest(
        val accountId: String,
        val password: String,
        val username: String
)
