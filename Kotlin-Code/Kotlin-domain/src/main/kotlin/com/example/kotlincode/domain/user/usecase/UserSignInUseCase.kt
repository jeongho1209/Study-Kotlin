package com.example.kotlincode.domain.user.usecase

import com.example.kotlincode.annotation.UseCase
import com.example.kotlincode.domain.user.dto.DomainUserSignInRequest
import com.example.kotlincode.domain.user.dto.TokenResponse
import com.example.kotlincode.domain.user.exception.PasswordMisMatchException
import com.example.kotlincode.domain.user.exception.UserNotFoundException
import com.example.kotlincode.domain.user.spi.QueryUserSpi
import com.example.kotlincode.domain.user.spi.UserJwtPort
import com.example.kotlincode.domain.user.spi.UserSecuritySpi

@UseCase
class UserSignInUseCase(
    private val queryUserSpi: QueryUserSpi,
    private val userSecuritySpi: UserSecuritySpi,
    private val userJwtPort: UserJwtPort,
) {

    fun execute(request: DomainUserSignInRequest): TokenResponse {
        val user = queryUserSpi.getAccountId(request.accountId) ?: throw UserNotFoundException

        if (!userSecuritySpi.matches(request.password, user.password)) {
            throw PasswordMisMatchException
        }

        return userJwtPort.receiveToken(user.accountId)
    }

}