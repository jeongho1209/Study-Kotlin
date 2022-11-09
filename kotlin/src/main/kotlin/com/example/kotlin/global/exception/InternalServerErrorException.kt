package com.example.kotlin.global.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

class InternalServerErrorException private constructor() : CustomException(ErrorCode.INTERNAL_SERVER_ERROR) {

    companion object {
        @JvmField
        val EXCEPTION = InternalServerErrorException()
    }

}