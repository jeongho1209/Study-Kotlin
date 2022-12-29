package com.kotlin.good.domain.order.presentation.dto.response

import java.util.*

data class QueryOrderItemElement(
    val orderItemId: UUID,
    val count: Int,
    val price: Int
)
