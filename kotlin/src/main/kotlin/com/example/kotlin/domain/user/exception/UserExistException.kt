package com.example.kotlin.domain.user.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

class UserExistException private constructor() : CustomException(error = ErrorCode.USER_EXIST) {

    companion object {
        @JvmField
        val EXCEPTION = UserExistException()
    }

}