package com.example.kotlin.global.error.response

import com.example.kotlin.global.error.CustomException

class BaseErrorResponse(
        val status: Int,
        val message: String
) {

    companion object {
        fun of(e: CustomException): BaseErrorResponse {
            return BaseErrorResponse(
                    status = e.status,
                    message = e.message
            )
        }
    }

}