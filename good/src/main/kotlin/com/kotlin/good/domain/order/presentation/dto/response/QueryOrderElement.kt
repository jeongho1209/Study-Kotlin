package com.kotlin.good.domain.order.presentation.dto.response

import com.kotlin.good.domain.user.presentation.dto.response.QueryUserElement
import com.kotlin.good.global.enum.OrderStatus
import java.time.LocalDate
import java.util.*

data class QueryOrderElement(
    val orderId: UUID,
    val orderDate: LocalDate,
    val orderStatus: OrderStatus,
    val orderItemList: List<QueryOrderItemElement>,
    val userInfo: QueryUserElement
)
