package com.example.kotlincode.domain.user.usecase

import com.example.kotlincode.annotation.UseCase
import com.example.kotlincode.domain.user.spi.CommandUserSpi
import com.example.kotlincode.domain.user.spi.UserSecuritySpi

@UseCase
class UserDeleteUseCase(
    private val userSecuritySpi: UserSecuritySpi,
    private val commandUserSpi: CommandUserSpi

) {

    fun execute() {
        val user = userSecuritySpi.getCurrentUserId()

        commandUserSpi.deleteUser(user)
    }

}