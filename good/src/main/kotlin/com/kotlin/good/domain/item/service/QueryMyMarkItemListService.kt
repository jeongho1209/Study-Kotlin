package com.kotlin.good.domain.item.service

import com.kotlin.good.domain.item.domain.repository.ItemRepository
import com.kotlin.good.domain.item.presentation.dto.response.QueryItemElement
import com.kotlin.good.domain.item.presentation.dto.response.QueryItemListResponse
import com.kotlin.good.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryMyMarkItemListService(
    private val itemRepository: ItemRepository,
    private val securityFacade: SecurityFacade
) {

    @Transactional(readOnly = true)
    fun execute(): QueryItemListResponse {
        val currentUser = securityFacade.getCurrentUser()

        val itemList = itemRepository.queryItemListByMark(currentUser)

        return QueryItemListResponse(
            itemList = itemList

                .filter { item ->
                    item.stock > 0
                }

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
        )
    }

}