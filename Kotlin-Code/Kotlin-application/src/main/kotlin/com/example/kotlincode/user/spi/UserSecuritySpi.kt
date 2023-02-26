package com.example.kotlincode.user.spi

import com.example.kotlincode.user.User

interface UserSecuritySpi {

    fun encodePassword(password: String): String

    fun matches(rawPassword: String, newPassword: String): Boolean

    fun getCurrentUserId(): User

}