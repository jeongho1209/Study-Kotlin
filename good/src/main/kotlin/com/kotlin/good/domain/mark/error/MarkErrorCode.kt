package com.kotlin.good.domain.mark.error

import com.kotlin.good.global.error.response.ErrorResponse

enum class MarkErrorCode(
    override val status: Int,
    override val message: String
) : ErrorResponse {

    MARK_EXIST(409, "Mark Exist")

}