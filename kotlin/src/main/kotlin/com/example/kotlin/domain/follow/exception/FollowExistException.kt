package com.example.kotlin.domain.follow.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

object FollowExistException : CustomException(ErrorCode.FOLLOW_EXIST) {

    val EXCEPTION = FollowExistException

}