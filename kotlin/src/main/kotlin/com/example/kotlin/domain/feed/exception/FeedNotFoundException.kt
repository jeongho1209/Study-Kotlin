package com.example.kotlin.domain.feed.exception

import com.example.kotlin.global.error.CustomException
import com.example.kotlin.global.error.ErrorCode

object FeedNotFoundException : CustomException(ErrorCode.FEED_NOT_FOUND) {

    val EXCEPTION = FeedNotFoundException

}