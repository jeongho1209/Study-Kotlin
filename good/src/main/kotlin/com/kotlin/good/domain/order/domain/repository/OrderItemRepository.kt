package com.kotlin.good.domain.order.domain.repository

import com.kotlin.good.domain.order.domain.OrderItem
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OrderItemRepository : CrudRepository<OrderItem, UUID> {
}