package com.example.kotlin.infrastructure.feign.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

object FeignForbiddenException : CustomException(ErrorCode.FEIGN_FORBIDDEN) {

    val EXCEPTION = FeignForbiddenException

}