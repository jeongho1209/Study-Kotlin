package com.example.kotlin.domain.feed.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

object CannotUpdateFeedException : CustomException(ErrorCode.CANNOT_UPDATE_FEED) {

    val EXCEPTION = CannotUpdateFeedException

}