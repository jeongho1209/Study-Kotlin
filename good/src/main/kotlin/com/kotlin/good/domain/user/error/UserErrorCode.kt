package com.kotlin.good.domain.user.error

import com.kotlin.good.global.error.response.ErrorResponse

enum class UserErrorCode(
    override val status: Int,
    override val message: String
) : ErrorResponse {

    USER_NOT_FOUND(404, "User Not Found"),

    USER_EXIST(409, "User Exist")

}