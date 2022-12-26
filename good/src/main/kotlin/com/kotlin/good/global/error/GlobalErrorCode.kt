package com.kotlin.good.global.error

import com.kotlin.good.global.error.response.ErrorResponse

enum class GlobalErrorCode(
    override val status: Int,
    override val message: String
) : ErrorResponse {

    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}