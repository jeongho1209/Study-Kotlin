package com.kotlin.good.domain.order.service

import com.kotlin.good.domain.order.domain.repository.OrderItemRepository
import com.kotlin.good.domain.order.domain.repository.OrderRepository
import com.kotlin.good.domain.order.presentation.dto.response.QueryMyOrderListResponse
import com.kotlin.good.domain.order.presentation.dto.response.QueryOrderElement
import com.kotlin.good.domain.order.presentation.dto.response.QueryOrderItemElement
import com.kotlin.good.domain.user.presentation.dto.response.QueryUserElement
import com.kotlin.good.global.enum.OrderStatus
import com.kotlin.good.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class QueryMyOrderListService(
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
    private val securityFacade: SecurityFacade
) {

    @Transactional(readOnly = true)
    fun execute(orderId: UUID): QueryMyOrderListResponse {
        val user = securityFacade.getCurrentUser()
        val orderList = orderRepository.queryMyOrderList(user.id)
        val orderItemList = orderItemRepository.queryMyOrderItems(orderId, user.id)

        val response = orderList
            .filter { order ->
                order.orderStatus == OrderStatus.ORDER
            }
            .map { order ->
                QueryOrderElement(
                    orderId = order.id,
                    orderDate = order.orderDate,
                    orderStatus = order.orderStatus,
                    orderItemList = orderItemList.map {
                        QueryOrderItemElement(
                            orderItemId = it.id,
                            count = it.count,
                            price = it.price,
                        )
                    },
                    userInfo = QueryUserElement(
                        name = user.name,
                        address = user.address
                    )
                )
            }

        return QueryMyOrderListResponse(response)
    }

}