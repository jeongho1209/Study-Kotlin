package com.example.kotlin.global.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

object UnExpectedTokenException : CustomException(ErrorCode.UNEXPECTED_TOKEN) {

    val EXCEPTION = UnExpectedTokenException

}