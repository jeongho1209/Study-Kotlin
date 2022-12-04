package com.example.kotlin.infrastructure.feign.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

object FeignBadRequestException : CustomException(ErrorCode.FEIGN_BAD_REQUEST) {

    val EXCEPTION = FeignBadRequestException

}