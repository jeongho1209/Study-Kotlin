package com.example.kotlincode.domain.user.dto

import java.util.*

data class TokenResponse(
        val accessToken: String,

        val refreshToken: String,

        val accessTokenExp: Date
)
