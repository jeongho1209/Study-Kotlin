package com.example.kotlincode.user.exception

import com.example.kotlincode.user.error.UserErrorCode
import com.example.kotlincode.common.error.BusinessException

object UserExistException : BusinessException(UserErrorCode.USER_EXIST) {
}