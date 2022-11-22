package com.example.kotlin.domain.follow.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

object CannotFollowYourselfException : CustomException(ErrorCode.CANNOT_FOLLOW_YOURSELF) {

    val EXCEPTION = CannotFollowYourselfException

}