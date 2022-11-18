package com.example.kotlincode.domain.user.usecase

import com.example.kotlincode.annotation.UseCase
import com.example.kotlincode.domain.user.api.UserSignUpApi
import com.example.kotlincode.domain.user.api.dto.DomainUserSignUpRequest
import com.example.kotlincode.domain.user.domain.User
import com.example.kotlincode.domain.user.exception.UserExistException
import com.example.kotlincode.domain.user.spi.CommandUserSpi
import com.example.kotlincode.domain.user.spi.QueryUserSpi

@UseCase
class UserSignUpUseCase(
        private val commandUserSpi: CommandUserSpi,
        private val queryUserSpi: QueryUserSpi

) : UserSignUpApi {

    override fun execute(request: DomainUserSignUpRequest) {
        if (queryUserSpi.existsUserByAccountId(request.accountId)) {
            throw UserExistException.EXCEPTION
        }

        commandUserSpi.save(User(
                id = 0,
                accountId = request.accountId,
                password = request.password,
                username = request.username
        ))
    }

}