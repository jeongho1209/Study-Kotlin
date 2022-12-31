package com.example.kotlincode.domain.user.spi

import com.example.kotlincode.domain.user.dto.TokenResponse

interface UserJwtPort {

    fun receiveToken(accountId: String): TokenResponse

}