package com.kotlin.good.domain.item.facade

import com.kotlin.good.domain.item.domain.Item
import com.kotlin.good.domain.item.domain.repository.ItemRepository
import com.kotlin.good.domain.item.error.exception.ItemNotFound
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.*

@Component
class ItemFacade(
    private val itemRepository: ItemRepository
) {

    fun getItemById(itemId: UUID): Item {
        return itemRepository.findByIdOrNull(itemId)
            ?: throw ItemNotFound.EXCEPTION
    }

}