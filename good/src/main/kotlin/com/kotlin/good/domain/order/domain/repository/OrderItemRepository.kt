package com.kotlin.good.domain.order.domain.repository

import com.kotlin.good.domain.order.domain.OrderItem
import com.kotlin.good.domain.order.domain.repository.custom.CustomOrderItemRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OrderItemRepository : CrudRepository<OrderItem, UUID>, CustomOrderItemRepository {
}