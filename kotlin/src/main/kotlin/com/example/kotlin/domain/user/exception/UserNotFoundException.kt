package com.example.kotlin.domain.user.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

class UserNotFoundException private constructor() : CustomException(ErrorCode.USER_NOT_FOUND) {

    companion object {
        @JvmField
        val EXCEPTION = UserNotFoundException()
    }

}