package com.example.kotlin.domain.user.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

object InvalidEmailException : CustomException(ErrorCode.INVALID_EMAIL) {
    val EXCEPTION = InvalidEmailException
}