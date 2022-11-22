package com.example.kotlin.domain.feed.presentation.dto.response

import java.time.LocalDateTime

data class FeedElement(
        val feedId: Long,
        val title: String,
        val content: String,
        val createdAt: LocalDateTime
)
