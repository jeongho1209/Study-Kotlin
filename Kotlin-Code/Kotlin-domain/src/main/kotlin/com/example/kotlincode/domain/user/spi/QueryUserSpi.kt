package com.example.kotlincode.domain.user.spi

import com.example.kotlincode.domain.user.domain.User

interface QueryUserSpi {

    fun existsUserByAccountId(accountId: String?): Boolean

}