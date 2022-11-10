package com.example.kotlin.domain.user.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

class PasswordMisMatchException private constructor() : CustomException(ErrorCode.PASSWORD_MIS_MATCH) {

    companion object {
        @JvmField
        val EXCEPTION = PasswordMisMatchException()
    }

}