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
    CANNOT_DELETE_FEED(401, "Cannot Delete Feed"),
    CANNOT_UPDATE_FEED(401, "Cannot Update Feed"),
    CANNOT_FOLLOW_YOURSELF(401, "Cannot Follow Yourself"),

    USER_NOT_FOUND(404, "User Not Found"),
    FEED_NOT_FOUND(404, "Feed Not Found"),

    USER_EXIST(409, "User Exist"),
    FOLLOW_EXIST(409, "Follow Exist"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")

}