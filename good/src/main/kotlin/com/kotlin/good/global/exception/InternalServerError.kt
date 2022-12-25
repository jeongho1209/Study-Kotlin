package com.kotlin.good.global.exception

import com.kotlin.good.global.error.CustomException
import com.kotlin.good.global.error.GlobalErrorCode

object InternalServerError : CustomException(GlobalErrorCode.INTERNAL_SERVER_ERROR) {

    val EXCEPTION = InternalServerError

}