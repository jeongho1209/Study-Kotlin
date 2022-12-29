package com.kotlin.good.domain.order.presentation

import com.kotlin.good.domain.order.presentation.dto.request.CreateOrderRequest
import com.kotlin.good.domain.order.presentation.dto.response.CreateOrderResponse
import com.kotlin.good.domain.order.presentation.dto.response.QueryMyOrderListResponse
import com.kotlin.good.domain.order.service.CancelOrderService
import com.kotlin.good.domain.order.service.CreateOrderService
import com.kotlin.good.domain.order.service.QueryMyOrderListService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/order")
@RestController
class OrderController(
    private val createOrderService: CreateOrderService,
    private val cancelOrderService: CancelOrderService,
    private val queryMyOrderListService: QueryMyOrderListService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{item-id}")
    fun createOrder(
        @PathVariable("item-id") itemId: UUID,
        @RequestBody request: CreateOrderRequest,
    ): CreateOrderResponse {
        return createOrderService.execute(itemId, request)
    }

    @GetMapping
    fun queryMyOrderList(
        @RequestParam("order-id")
        orderId: UUID,
    ): QueryMyOrderListResponse {
        return queryMyOrderListService.execute(orderId)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{order-id}")
    fun cancelOrder(
        @PathVariable("order-id")
        orderId: UUID,
    ) {
        cancelOrderService.execute(orderId)
    }
}