package com.example.kotlincode.user.spi

import com.example.kotlincode.user.User

interface CommandUserSpi {

    fun save(user: User)

    fun deleteUser(user: User)
}