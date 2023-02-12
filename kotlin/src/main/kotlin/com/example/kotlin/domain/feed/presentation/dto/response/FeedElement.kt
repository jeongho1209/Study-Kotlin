package com.example.kotlin.domain.feed.presentation.dto.response

import com.example.kotlin.domain.feed.domain.Feed
import java.time.LocalDateTime

data class FeedElement(
    val feedId: Long,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
) {
    constructor(feed: Feed) : this(
        feedId = feed.id,
        title = feed.title,
        content = feed.content,
        createdAt = feed.createdAt,
    )
}
