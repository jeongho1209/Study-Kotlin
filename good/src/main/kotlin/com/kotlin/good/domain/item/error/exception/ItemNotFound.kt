package com.kotlin.good.domain.item.error.exception

import com.kotlin.good.domain.item.error.ItemErrorCode
import com.kotlin.good.global.error.CustomException

object ItemNotFound : CustomException(ItemErrorCode.ITEM_NOT_FOUND) {

    val EXCEPTION = ItemNotFound

}