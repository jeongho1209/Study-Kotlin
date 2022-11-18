package com.example.kotlincode.domain.user.spi

import com.example.kotlincode.domain.user.domain.User

interface CommandUserSpi {

    fun save(user: User)

}