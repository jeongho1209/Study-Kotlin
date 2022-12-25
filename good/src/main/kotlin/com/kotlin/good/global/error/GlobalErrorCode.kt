package com.kotlin.good.global.error

import com.kotlin.good.global.error.response.ErrorResponse

enum class GlobalErrorCode(
    override val status: Int,
    override val message: String
) : ErrorResponse {

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}