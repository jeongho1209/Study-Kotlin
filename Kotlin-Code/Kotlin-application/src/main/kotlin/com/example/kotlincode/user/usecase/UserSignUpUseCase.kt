package com.example.kotlincode.user.usecase

import com.example.kotlincode.common.annotation.UseCase
import com.example.kotlincode.user.User
import com.example.kotlincode.user.dto.DomainUserSignUpRequest
import com.example.kotlincode.user.exception.UserExistException
import com.example.kotlincode.user.spi.CommandUserSpi
import com.example.kotlincode.user.spi.QueryUserSpi
import com.example.kotlincode.user.spi.UserSecuritySpi

@UseCase
class UserSignUpUseCase(
    private val commandUserSpi: CommandUserSpi,
    private val queryUserSpi: QueryUserSpi,
    private val userSecuritySpi: UserSecuritySpi
) {

    fun execute(request: DomainUserSignUpRequest) {
        if (queryUserSpi.existsUserByAccountId(request.accountId)) {
            throw UserExistException
        }

        commandUserSpi.save(
                User(
                        accountId = request.accountId,
                        password = userSecuritySpi.encodePassword(request.password),
                        username = request.username
                )
        )
    }

}