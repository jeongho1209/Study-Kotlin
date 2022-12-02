package com.example.kotlincode.domain.user.dto

data class DomainUserSignInRequest(
        val accountId: String,
        val password: String
)
