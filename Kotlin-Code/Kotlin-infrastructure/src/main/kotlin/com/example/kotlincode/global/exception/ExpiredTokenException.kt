package com.example.kotlincode.global.exception

import com.example.kotlincode.error.BusinessException
import com.example.kotlincode.global.error.GlobalErrorCode

object ExpiredTokenException : BusinessException(GlobalErrorCode.EXPIRED_TOKEN) {

    val EXCEPTION = ExpiredTokenException

}