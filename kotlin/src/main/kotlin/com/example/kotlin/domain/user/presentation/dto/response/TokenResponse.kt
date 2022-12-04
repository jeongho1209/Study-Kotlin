package com.example.kotlin.domain.user.presentation.dto.response

import java.util.Date

data class TokenResponse(
        val accessToken: String,
        val refreshToken: String,
        val accessTokenExp: Date
)
