package com.kotlin.good.domain.item.presentation.dto.response

import java.util.*

data class QueryItemElement(
    val itemId: UUID,
    val itemName: String,
    val itemInfo: String,
    val price: Int,
    val stock: Int,
    var markCount: Int,
)
