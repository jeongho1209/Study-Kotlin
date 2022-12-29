package com.kotlin.good.domain.order.domain.repository.custom

import com.kotlin.good.domain.order.domain.Order
import java.util.UUID

interface CustomOrderRepository {

    fun queryMyOrderList(userId: UUID): List<Order>

}