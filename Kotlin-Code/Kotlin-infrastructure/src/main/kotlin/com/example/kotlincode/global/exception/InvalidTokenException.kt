package com.example.kotlincode.global.exception

import com.example.kotlincode.error.BusinessException
import com.example.kotlincode.global.error.GlobalErrorCode

object InvalidTokenException : BusinessException(GlobalErrorCode.INVALID_TOKEN) {

    val EXCEPTION = InvalidTokenException

}