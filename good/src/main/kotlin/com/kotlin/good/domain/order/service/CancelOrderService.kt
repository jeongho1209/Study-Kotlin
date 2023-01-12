package com.kotlin.good.domain.order.service

import com.kotlin.good.domain.order.domain.repository.OrderItemRepository
import com.kotlin.good.domain.order.error.exception.CannotCancelOrder
import com.kotlin.good.domain.order.facade.OrderFacade
import com.kotlin.good.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class CancelOrderService(
    private val securityFacade: SecurityFacade,
    private val orderFacade: OrderFacade,
    private val orderItemRepository: OrderItemRepository
) {

    @Transactional
    fun execute(orderId: UUID) {
        val order = orderFacade.getOrderById(orderId)

        val user = securityFacade.getCurrentUser()

        if (user != order.user) {
            throw CannotCancelOrder.EXCEPTION
        }

        val orderItems = order.orderItems
        orderItemRepository.deleteAll(orderItems)

        order.cancelOrder()

    }

}