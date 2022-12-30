package com.kotlin.good.global.error.response

import com.kotlin.good.global.error.CustomException

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