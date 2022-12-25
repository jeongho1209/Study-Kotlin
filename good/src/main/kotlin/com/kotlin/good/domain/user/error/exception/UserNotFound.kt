package com.kotlin.good.domain.user.error.exception

import com.kotlin.good.domain.user.error.UserErrorCode
import com.kotlin.good.global.error.CustomException

object UserNotFound : CustomException(UserErrorCode.USER_NOT_FOUND) {

    val EXCEPTION = UserNotFound
}