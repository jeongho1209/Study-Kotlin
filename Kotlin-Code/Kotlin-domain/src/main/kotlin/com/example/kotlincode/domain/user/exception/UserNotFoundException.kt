package com.example.kotlincode.domain.user.exception

import com.example.kotlincode.domain.user.error.UserErrorCode
import com.example.kotlincode.error.BusinessException

object UserNotFoundException : BusinessException(UserErrorCode.USER_NOT_FOUND) {

    val EXCEPTION = UserNotFoundException

}