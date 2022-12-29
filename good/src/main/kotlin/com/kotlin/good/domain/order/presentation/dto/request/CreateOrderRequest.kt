package com.kotlin.good.domain.order.presentation.dto.request

data class CreateOrderRequest(
    val count: Int,
    val address: String
)
