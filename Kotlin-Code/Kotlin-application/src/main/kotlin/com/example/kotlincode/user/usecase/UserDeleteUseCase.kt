package com.example.kotlincode.user.usecase

import com.example.kotlincode.common.annotation.UseCase
import com.example.kotlincode.user.spi.CommandUserSpi
import com.example.kotlincode.user.spi.UserSecuritySpi

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