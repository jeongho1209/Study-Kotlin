package com.kotlin.good.domain.order.facade

import com.kotlin.good.domain.order.domain.Order
import com.kotlin.good.domain.order.domain.repository.OrderRepository
import com.kotlin.good.domain.order.error.exception.OrderNotFound
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.*

@Component
class OrderFacade(
    private val orderRepository: OrderRepository
) {

    fun getOrderById(orderId: UUID): Order {
        return orderRepository.findByIdOrNull(orderId)
            ?: throw OrderNotFound.EXCEPTION
    }

}