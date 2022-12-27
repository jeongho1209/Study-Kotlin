package com.kotlin.good.domain.item.error

import com.kotlin.good.global.error.response.ErrorResponse

enum class ItemErrorCode(
    override val status: Int,
    override val message: String
) : ErrorResponse {

    ITEM_NOT_FOUND(404, "Item Not Found")

}