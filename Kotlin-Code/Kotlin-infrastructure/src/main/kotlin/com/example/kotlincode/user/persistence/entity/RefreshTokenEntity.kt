package com.example.kotlincode.user.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshTokenEntity(
        @Id
        val accountId: String,

        @Indexed
        val token: String,

        @TimeToLive
        val expiredAt: Long
)