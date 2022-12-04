package com.example.kotlin.domain.refresh_token

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshToken(
        @Id
        val email: String,

        @Indexed
        val token: String,

        @TimeToLive
        val expiredAt: Long
)