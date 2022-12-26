package com.kotlin.good.global.exception

import com.kotlin.good.global.error.CustomException
import com.kotlin.good.global.error.GlobalErrorCode

object ExpiredToken : CustomException(GlobalErrorCode.EXPIRED_TOKEN) {

    val EXCEPTION = ExpiredToken
}