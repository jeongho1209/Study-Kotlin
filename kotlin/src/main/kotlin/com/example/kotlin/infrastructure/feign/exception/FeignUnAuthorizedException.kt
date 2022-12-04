package com.example.kotlin.infrastructure.feign.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

object FeignUnAuthorizedException : CustomException(ErrorCode.FEIGN_UN_AUTHORIZED) {

    val EXCEPTION = FeignUnAuthorizedException

}