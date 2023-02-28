package com.example.kotlincode.user

import com.example.kotlincode.common.annotation.Aggregate

@Aggregate
data class User(
        val id: Long = 0,

        val accountId: String,

        val password: String,

        val username: String,

)
