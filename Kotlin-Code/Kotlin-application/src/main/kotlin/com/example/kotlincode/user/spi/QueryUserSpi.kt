package com.example.kotlincode.user.spi

import com.example.kotlincode.user.User

interface QueryUserSpi {

    fun existsUserByAccountId(accountId: String?): Boolean

    fun getAccountId(accountId: String): User?

}