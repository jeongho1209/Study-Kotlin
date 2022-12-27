package com.kotlin.good.domain.order.presentation

import com.kotlin.good.domain.order.presentation.dto.request.CreateOrderRequest
import com.kotlin.good.domain.order.presentation.dto.response.CreateOrderResponse
import com.kotlin.good.domain.order.service.CreateOrderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/order")
@RestController
class OrderController(
    private val createOrderService: CreateOrderService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{item-id}")
    fun createOrder(
        @PathVariable("item-id") itemId: UUID,
        @RequestBody request: CreateOrderRequest
    ): CreateOrderResponse {
        return createOrderService.execute(itemId, request)
    }

}