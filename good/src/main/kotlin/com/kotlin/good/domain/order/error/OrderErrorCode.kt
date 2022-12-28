package com.kotlin.good.domain.order.error

import com.kotlin.good.global.error.response.ErrorResponse

enum class OrderErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorResponse {

    CANNOT_CANCEL_ORDER(401, "Cannot Cancel Order"),

    ORDER_NOT_FOUND(404, "Order Not Found"),

    ALREADY_CANCLE_ORDER(409, "Already Cancel Order")
}