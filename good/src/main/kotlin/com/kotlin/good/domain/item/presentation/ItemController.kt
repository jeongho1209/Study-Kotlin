package com.kotlin.good.domain.item.presentation

import com.kotlin.good.domain.item.presentation.dto.request.CreateItemRequest
import com.kotlin.good.domain.item.presentation.dto.response.CreateItemResponse
import com.kotlin.good.domain.item.presentation.dto.response.QueryItemListResponse
import com.kotlin.good.domain.item.service.CreateItemService
import com.kotlin.good.domain.item.service.QueryItemListService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/item")
@RestController
class ItemController(
    private val createItemService: CreateItemService,
    private val queryItemListService: QueryItemListService
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

}