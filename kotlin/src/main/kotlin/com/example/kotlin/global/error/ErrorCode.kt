package com.example.kotlin.global.error

import com.example.kotlin.global.error.response.ErrorResponse

enum class ErrorCode(
        override val status: Int,
        override val message: String
) : ErrorResponse {

    PASSWORD_MIS_MATCH(401, "Password Mis Match"),
    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),
    UNEXPECTED_TOKEN(401, "Unexpected Token"),

    USER_NOT_FOUND(404, "User Not Found"),

    USER_EXIST(409, "User Exist"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")

}