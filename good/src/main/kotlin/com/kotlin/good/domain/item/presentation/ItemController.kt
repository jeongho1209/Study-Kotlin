package com.kotlin.good.domain.item.presentation

import com.kotlin.good.domain.item.presentation.dto.request.AddItemStockRequest
import com.kotlin.good.domain.item.presentation.dto.request.CreateItemRequest
import com.kotlin.good.domain.item.presentation.dto.response.CreateItemResponse
import com.kotlin.good.domain.item.presentation.dto.response.QueryItemListResponse
import com.kotlin.good.domain.item.service.AddItemStockService
import com.kotlin.good.domain.item.service.CreateItemService
import com.kotlin.good.domain.item.service.QueryItemListService
import com.kotlin.good.domain.item.service.QueryMyMarkItemListService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/item")
@RestController
class ItemController(
    private val createItemService: CreateItemService,
    private val queryItemListService: QueryItemListService,
    private val queryMyMarkItemListService: QueryMyMarkItemListService,
    private val addItemStockService: AddItemStockService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createItem(@RequestBody request: CreateItemRequest): CreateItemResponse {
        return createItemService.execute(request)
    }

    @GetMapping
    fun queryItemList(@RequestParam("price") price: Int): QueryItemListResponse {
        return queryItemListService.execute(price)
    }

    @GetMapping("/my")
    fun queryMyMarkItemList(): QueryItemListResponse {
        return queryMyMarkItemListService.execute()
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{item-id}")
    fun addStock(
        @RequestBody request: AddItemStockRequest,
        @PathVariable("item-id") itemId: UUID
    ) {
        addItemStockService.execute(request, itemId)
    }

}