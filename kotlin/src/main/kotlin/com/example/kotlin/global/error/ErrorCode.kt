package com.example.kotlin.global.error

import com.example.kotlin.global.error.response.ErrorResponse

enum class ErrorCode(
        override val status: Int,
        override val message: String
) : ErrorResponse {

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")

}