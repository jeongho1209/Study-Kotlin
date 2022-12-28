package com.kotlin.good.domain.order.error.exception

import com.kotlin.good.domain.order.error.OrderErrorCode
import com.kotlin.good.global.error.CustomException

object AlreadyCancelOrder : CustomException(OrderErrorCode.ALREADY_CANCLE_ORDER) {

    val EXCEPTION = AlreadyCancelOrder
}