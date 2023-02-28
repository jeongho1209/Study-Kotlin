package com.example.kotlincode.user

import com.example.kotlincode.common.annotation.Aggregate

@Aggregate
data class RefreshToken(
        val accountId: String,

        val token: String,

        val expiredAt: Long
)
