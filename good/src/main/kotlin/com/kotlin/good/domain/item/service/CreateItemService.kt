package com.kotlin.good.domain.item.service

import com.kotlin.good.domain.item.domain.Item
import com.kotlin.good.domain.item.domain.repository.ItemRepository
import com.kotlin.good.domain.item.presentation.dto.request.CreateItemRequest
import com.kotlin.good.domain.item.presentation.dto.response.CreateItemResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class CreateItemService(
    private val itemRepository: ItemRepository
) {

    @Transactional
    fun execute(request: CreateItemRequest): CreateItemResponse {
        val (name, stock, price, itemInfo) = request

        itemRepository.save(
            Item(
                id = UUID.randomUUID(),
                name = name,
                stock = stock,
                price = price,
                itemInfo = itemInfo,
                markCount = 0,
            )
        )

        return CreateItemResponse(request.name + "상품 등록 완료")
    }
}
