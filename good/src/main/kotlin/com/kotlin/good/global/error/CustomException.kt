package com.kotlin.good.global.error

import com.kotlin.good.global.error.response.ErrorResponse

open class CustomException(private val error: ErrorResponse) : RuntimeException() {

    val status: Int
        get() = error.status

    override val message: String
        get() = error.message

}