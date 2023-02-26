package com.example.kotlincode.user.dto

data class DomainUserSignUpRequest(
        val accountId: String,
        val password: String,
        val username: String
)
