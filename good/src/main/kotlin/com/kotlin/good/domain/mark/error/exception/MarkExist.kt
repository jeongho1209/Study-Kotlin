package com.kotlin.good.domain.mark.error.exception

import com.kotlin.good.domain.mark.error.MarkErrorCode
import com.kotlin.good.global.error.CustomException

object MarkExist : CustomException(MarkErrorCode.MARK_EXIST) {

    val EXCEPTINON = MarkExist

}