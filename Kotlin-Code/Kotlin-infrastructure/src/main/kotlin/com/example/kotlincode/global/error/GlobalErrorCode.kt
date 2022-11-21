package com.example.kotlincode.global.error

import com.example.kotlincode.error.ErrorProperty

enum class GlobalErrorCode(
        private val status: Int,
        private val message: String
) : ErrorProperty {

    BAD_REQUEST(400, "Bad Request"),

    INVALID_TOKEN(401, "Invalid Token"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
    ;

    override fun status(): Int = status
    override fun message(): String = message

}