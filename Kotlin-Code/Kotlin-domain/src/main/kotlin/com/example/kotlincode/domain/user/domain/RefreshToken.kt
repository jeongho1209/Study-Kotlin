package com.example.kotlincode.domain.user.domain

import com.example.kotlincode.annotation.Aggregate

@Aggregate
data class RefreshToken(
        val accountId: String,

        val token: String,

        val expiredAt: Long
)
