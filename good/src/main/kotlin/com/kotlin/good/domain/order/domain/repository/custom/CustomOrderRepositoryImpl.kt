package com.kotlin.good.domain.order.domain.repository.custom

import com.kotlin.good.domain.order.domain.Order
import com.kotlin.good.domain.order.domain.QOrder.order
import com.kotlin.good.domain.order.domain.repository.custom.CustomOrderRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import java.util.*

class CustomOrderRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : CustomOrderRepository {

    override fun queryMyOrderList(userId: UUID): List<Order> {
        return queryFactory
            .selectFrom(order)
            .where(order.user.id.eq(userId))
            .fetch()
    }

}