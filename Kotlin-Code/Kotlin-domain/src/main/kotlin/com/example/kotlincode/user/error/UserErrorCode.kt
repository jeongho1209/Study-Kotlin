package com.example.kotlincode.user.error

import com.example.kotlincode.common.error.ErrorProperty

enum class UserErrorCode(
        private val status: Int,
        private val message: String
) : ErrorProperty {

    PASSWORD_MIS_MATCH(401, "Password Mis Match"),

    USER_NOT_FOUND(404, "User Not Found"),

    USER_EXIST(409, "User Exist")
    ;

    override fun status(): Int = status
    override fun message(): String = message

}