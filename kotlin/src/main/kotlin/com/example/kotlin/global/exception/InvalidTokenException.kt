package com.example.kotlin.global.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

object InvalidTokenException : CustomException(ErrorCode.INVALID_TOKEN) {

    val EXCEPTION = InvalidTokenException

}