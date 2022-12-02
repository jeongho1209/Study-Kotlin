package com.example.kotlincode.domain.user.exception

import com.example.kotlincode.domain.user.error.UserErrorCode
import com.example.kotlincode.error.BusinessException

object PasswordMisMatchException : BusinessException(UserErrorCode.PASSWORD_MIS_MATCH) {
}