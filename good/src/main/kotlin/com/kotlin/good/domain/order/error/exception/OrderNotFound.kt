package com.kotlin.good.domain.order.error.exception

import com.kotlin.good.domain.order.error.OrderErrorCode
import com.kotlin.good.global.error.CustomException

object OrderNotFound : CustomException(OrderErrorCode.ORDER_NOT_FOUND) {

    val EXCEPTION = OrderNotFound

}