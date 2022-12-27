package com.kotlin.good.domain.item.domain.repository

import com.kotlin.good.domain.item.domain.Item
import com.kotlin.good.domain.item.domain.QItem.item
import com.querydsl.jpa.impl.JPAQueryFactory


class CustomItemRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : CustomItemRepository {

    override fun queryItemListByPrice(price: Int): List<Item> {
        return queryFactory
            .selectFrom(item)
            .where(item.price.gt(price))
            .orderBy(item.price.desc())
            .fetch()
    }


}

