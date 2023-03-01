package com.example.kotlincode.common.exception

import com.example.kotlincode.common.error.BusinessException
import com.example.kotlincode.common.error.GlobalErrorCode

object InternalServerErrorException : BusinessException(GlobalErrorCode.INTERNAL_SERVER_ERROR) {

    val EXCEPTION = InternalServerErrorException

}