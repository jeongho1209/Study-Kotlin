package com.kotlin.good.global.exception

import com.kotlin.good.global.error.CustomException
import com.kotlin.good.global.error.GlobalErrorCode

object InvalidToken : CustomException(GlobalErrorCode.INVALID_TOKEN) {

    val EXCEPTION = InvalidToken
}