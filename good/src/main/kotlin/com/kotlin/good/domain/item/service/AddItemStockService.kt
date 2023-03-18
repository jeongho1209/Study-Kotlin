package com.kotlin.good.domain.item.service

import com.kotlin.good.domain.item.facade.ItemFacade
import com.kotlin.good.domain.item.presentation.dto.request.AddItemStockRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class AddItemStockService(
    private val itemFacade: ItemFacade
) {

    @Transactional
    fun execute(request: AddItemStockRequest, itemId: UUID) {
        val item = itemFacade.getItemById(itemId)

        item.plusStock(request.stock)
    }
}
