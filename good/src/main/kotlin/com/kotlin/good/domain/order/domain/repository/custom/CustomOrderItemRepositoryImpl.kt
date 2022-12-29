package com.kotlin.good.domain.order.domain.repository.custom

import com.kotlin.good.domain.order.domain.OrderItem
import com.kotlin.good.domain.order.domain.QOrderItem.orderItem
import com.querydsl.jpa.impl.JPAQueryFactory
import java.util.*

class CustomOrderItemRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : CustomOrderItemRepository {

    override fun queryMyOrderItems(orderId: UUID, userId: UUID): List<OrderItem> {
        return queryFactory
            .selectFrom(orderItem)
            .where(
                orderItem.order.user.id.eq(userId)
                    .and(orderItem.order.id.eq(orderId))
            )
            .fetch()
    }

}