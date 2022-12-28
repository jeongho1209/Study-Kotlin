package com.kotlin.good.domain.order.domain.repository

import com.kotlin.good.domain.order.domain.Order
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OrderRepository : CrudRepository<Order, UUID>, CustomOrderRepository {
}