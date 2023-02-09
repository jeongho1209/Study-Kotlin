package com.example.kotlin.domain.user.presentation.dto.response

data class QueryMyInfoResponse(
    val followingCounts: Int,
    val followedCounts: Int
)
