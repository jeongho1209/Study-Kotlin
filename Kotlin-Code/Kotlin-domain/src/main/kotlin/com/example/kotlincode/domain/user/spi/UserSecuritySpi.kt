package com.example.kotlincode.domain.user.spi

interface UserSecuritySpi {

    fun encodePassword(password: String): String

}