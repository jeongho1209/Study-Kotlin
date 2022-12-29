package com.kotlin.good.domain.order.service

import com.kotlin.good.domain.delivery.domain.Delivery
import com.kotlin.good.domain.delivery.domain.repository.DeliveryRepository
import com.kotlin.good.domain.item.facade.ItemFacade
import com.kotlin.good.domain.order.domain.Order
import com.kotlin.good.domain.order.domain.OrderItem
import com.kotlin.good.domain.order.domain.repository.OrderItemRepository
import com.kotlin.good.domain.order.domain.repository.OrderRepository
import com.kotlin.good.domain.order.presentation.dto.request.CreateOrderRequest
import com.kotlin.good.domain.order.presentation.dto.response.CreateOrderResponse
import com.kotlin.good.global.enum.DeliveryStatus
import com.kotlin.good.global.enum.OrderStatus
import com.kotlin.good.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.util.*

@Service
class CreateOrderService(
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
    private val deliveryRepository: DeliveryRepository,
    private val securityFacade: SecurityFacade,
    private val itemFacade: ItemFacade
) {

    @Transactional
    fun execute(
        itemId: UUID,
        request: CreateOrderRequest
    ): CreateOrderResponse {
        val user = securityFacade.getCurrentUser()
        val item = itemFacade.getItemById(itemId)

        val order = orderRepository.save(
            Order(
                id = UUID.randomUUID(),
                orderDate = LocalDate.now(),
                orderStatus = OrderStatus.ORDER,
                user = user
            )
        )

        orderItemRepository.save(
            OrderItem(
                id = UUID.randomUUID(),
                count = request.count,
                price = item.price,
                order = order,
                item = item
            )
        )

        deliveryRepository.save(
            Delivery(
                id = UUID.randomUUID(),
                address = request.address,
                deliveryStatus = DeliveryStatus.START,
                order = order
            )
        )

        item.minusStock(request.count)

        return CreateOrderResponse(item.name + "주문 완료!", item.stock)
    }

}