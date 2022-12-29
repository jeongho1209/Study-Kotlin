package com.kotlin.good.domain.order.domain.repository.custom

import com.kotlin.good.domain.order.domain.OrderItem
import java.util.*

interface CustomOrderItemRepository {

    fun queryMyOrderItems(orderId: UUID, userId: UUID): List<OrderItem>

}