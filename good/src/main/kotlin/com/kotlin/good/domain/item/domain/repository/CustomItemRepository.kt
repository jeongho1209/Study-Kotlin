package com.kotlin.good.domain.item.domain.repository

import com.kotlin.good.domain.item.domain.Item
import com.kotlin.good.domain.user.domain.User

interface CustomItemRepository {

    fun queryItemListByPrice(price: Int): List<Item>

    fun queryItemListByMark(currentUser: User): List<Item>

}