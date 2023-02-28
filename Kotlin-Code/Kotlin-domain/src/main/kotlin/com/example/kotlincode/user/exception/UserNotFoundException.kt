package com.example.kotlincode.user.exception

import com.example.kotlincode.user.error.UserErrorCode
import com.example.kotlincode.common.error.BusinessException

object UserNotFoundException : BusinessException(UserErrorCode.USER_NOT_FOUND) {
}