package com.kotlin.good.domain.user.presentation.dto.response

import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExp: LocalDateTime
)
