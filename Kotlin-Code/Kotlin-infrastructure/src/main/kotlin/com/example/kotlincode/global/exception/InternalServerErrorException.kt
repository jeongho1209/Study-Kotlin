package com.example.kotlincode.global.exception

import com.example.kotlincode.error.BusinessException
import com.example.kotlincode.global.error.GlobalErrorCode

object InternalServerErrorException : BusinessException(GlobalErrorCode.INTERNAL_SERVER_ERROR) {

    val EXCEPTION = InternalServerErrorException

}