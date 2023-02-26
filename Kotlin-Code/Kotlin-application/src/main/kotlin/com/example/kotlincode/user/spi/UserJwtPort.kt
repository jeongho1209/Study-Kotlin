package com.example.kotlincode.user.spi

import com.example.kotlincode.user.dto.TokenResponse

interface UserJwtPort {

    fun receiveToken(accountId: String): TokenResponse

}