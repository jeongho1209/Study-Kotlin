package com.example.kotlincode.domain.user.error

import com.example.kotlincode.error.ErrorProperty

enum class UserErrorCode(
        private val status: Int,
        private val message: String
) : ErrorProperty {

    USER_NOT_FOUND(404, "User Not Found"),

    USER_EXIST(409, "User Exist")
    ;

    override fun status(): Int = status
    override fun message(): String = message

}