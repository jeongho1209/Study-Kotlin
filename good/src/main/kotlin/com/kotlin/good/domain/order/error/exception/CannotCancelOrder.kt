package com.kotlin.good.domain.order.error.exception

import com.kotlin.good.domain.order.error.OrderErrorCode
import com.kotlin.good.global.error.CustomException

object CannotCancelOrder : CustomException(OrderErrorCode.CANNOT_CANCEL_ORDER) {

    val EXCEPTION = CannotCancelOrder

}