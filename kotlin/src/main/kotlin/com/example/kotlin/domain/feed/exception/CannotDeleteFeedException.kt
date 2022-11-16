package com.example.kotlin.domain.feed.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

object CannotDeleteFeedException : CustomException(ErrorCode.CANNOT_DELETE_FEED) {

    val EXCEPTION = CannotDeleteFeedException

}