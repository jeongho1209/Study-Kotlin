package com.example.kotlin.global.error

import com.example.kotlin.global.error.response.ErrorResponse

open class CustomException(private val error: ErrorResponse) : RuntimeException() {

    val status: Int
        get() = error.status

    override val message: String
        get() = error.message

}