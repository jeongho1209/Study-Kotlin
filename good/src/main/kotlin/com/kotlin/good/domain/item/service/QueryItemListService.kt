package com.kotlin.good.domain.item.service

import com.kotlin.good.domain.item.domain.repository.ItemRepository
import com.kotlin.good.domain.item.presentation.dto.response.QueryItemElement
import com.kotlin.good.domain.item.presentation.dto.response.QueryItemListResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryItemListService(
    private val itemRepository: ItemRepository
) {

    @Transactional(readOnly = true)
    fun execute(price: Int): QueryItemListResponse {
        val itemList = itemRepository.queryItemListByPrice(price)
        val response = itemList
            .filter { it.stock > 0 }
            .map {
                QueryItemElement(
                    itemId = it.id,
                    itemName = it.name,
                    itemInfo = it.itemInfo,
                    price = it.price,
                    stock = it.stock,
                    markCount = it.markCount
                )
            }

        return QueryItemListResponse(response)
    }
}
