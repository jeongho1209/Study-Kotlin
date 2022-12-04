package com.example.kotlin.infrastructure.feign.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

object FeignExpiredTokenException : CustomException(ErrorCode.FEIGN_EXPIRED_TOKEN) {

    val EXCEPTION = FeignExpiredTokenException

}