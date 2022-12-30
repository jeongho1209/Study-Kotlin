package com.kotlin.good.domain.item.domain.repository

import com.kotlin.good.domain.item.domain.Item
import com.kotlin.good.domain.item.domain.QItem.item
import com.kotlin.good.domain.mark.domain.QMark.mark
import com.kotlin.good.domain.user.domain.User
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomItemRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : CustomItemRepository {

    override fun queryItemListByPrice(price: Int): List<Item> {
        return queryFactory
            .selectFrom(item)
            .where(item.price.gt(price))
            .orderBy(item.price.asc())
            .fetch()
    }

    override fun queryItemListByMark(currentUser: User): List<Item> {
        return queryFactory
            .selectFrom(item)
            .leftJoin(mark)
            .on(mark.user.id.eq(currentUser.id))
            .where(mark.item.id.eq(item.id))
            .orderBy(item.price.asc())
            .fetch()
    }

}

