package com.kotlin.good.domain.item.domain.repository

import com.kotlin.good.domain.item.domain.Item

interface CustomItemRepository {

    fun queryItemListByPrice(price: Int): List<Item>

}