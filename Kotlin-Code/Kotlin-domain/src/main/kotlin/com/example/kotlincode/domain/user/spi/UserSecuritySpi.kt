package com.example.kotlincode.domain.user.spi

import com.example.kotlincode.domain.user.domain.User

interface UserSecuritySpi {

    fun encodePassword(password: String): String

    fun matches(rawPassword: String, newPassword: String): Boolean

    fun getCurrentUserId(): User

}