package com.kotlin.good.domain.user.error.exception

import com.kotlin.good.domain.user.error.UserErrorCode
import com.kotlin.good.global.error.CustomException

object PasswordMisMatch : CustomException(UserErrorCode.PASSWORD_MIS_MATCH) {

    val EXCEPTION = PasswordMisMatch
}