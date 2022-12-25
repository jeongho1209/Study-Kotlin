package com.kotlin.good.domain.item.domain.repository

import com.kotlin.good.domain.item.domain.Item
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ItemRepository : CrudRepository<Item, UUID> {
}