package com.example.kotlincode.domain.user.spi

interface UserSecuritySpi {

    fun encodePassword(password: String): String

    fun matches(rawPassword: String, newPassword: String): Boolean

}