package com.kotlin.good.domain.item.presentation.dto.request

data class CreateItemRequest(
    val name: String,
    val stock: Int,
    val price: Int,
    val itemInfo: String
)
