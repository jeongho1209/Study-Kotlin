package com.example.kotlincode.domain.user.spi

interface QueryUserSpi {

    fun existsUserByAccountId(accountId: String?): Boolean

}