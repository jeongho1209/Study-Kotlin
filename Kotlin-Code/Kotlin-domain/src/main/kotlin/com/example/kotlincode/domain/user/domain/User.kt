package com.example.kotlincode.domain.user.domain

import com.example.kotlincode.annotation.Aggregate

@Aggregate
data class User(
        val id: Long,

        val accountId: String,

        val password: String,

        val username: String,

)
