package com.example.kotlin.global.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

object ExpiredTokenException : CustomException(ErrorCode.EXPIRED_TOKEN) {

    val EXCEPTION = ExpiredTokenException

}