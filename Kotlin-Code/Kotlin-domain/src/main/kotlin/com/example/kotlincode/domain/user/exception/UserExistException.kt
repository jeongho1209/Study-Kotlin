package com.example.kotlincode.domain.user.exception

import com.example.kotlincode.domain.user.error.UserErrorCode
import com.example.kotlincode.error.BusinessException

object UserExistException : BusinessException(UserErrorCode.USER_EXIST) {

    val EXCEPTION = UserExistException

}