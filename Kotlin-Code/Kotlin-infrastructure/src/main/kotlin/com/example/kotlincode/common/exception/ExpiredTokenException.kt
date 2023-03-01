package com.example.kotlincode.common.exception

import com.example.kotlincode.common.error.BusinessException
import com.example.kotlincode.common.error.GlobalErrorCode

object ExpiredTokenException : BusinessException(GlobalErrorCode.EXPIRED_TOKEN) {

    val EXCEPTION = ExpiredTokenException

}