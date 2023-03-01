package com.example.kotlincode.common.exception

import com.example.kotlincode.common.error.BusinessException
import com.example.kotlincode.common.error.GlobalErrorCode

object InvalidTokenException : BusinessException(GlobalErrorCode.INVALID_TOKEN) {

    val EXCEPTION = InvalidTokenException

}