package com.kotlin.good.domain.user.error.exception

import com.kotlin.good.domain.user.error.UserErrorCode
import com.kotlin.good.global.error.CustomException

object UserExist : CustomException(UserErrorCode.USER_EXIST) {

    val EXCEPTION = UserExist

}