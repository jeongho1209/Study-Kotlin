package com.kotlin.good.domain.user.domain.repository.vo

import com.querydsl.core.annotations.QueryProjection

class UserVo @QueryProjection constructor(
    val name: String,
    val address: String
)