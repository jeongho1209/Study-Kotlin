package com.example.kotlincode.domain.feed.domain

import com.example.kotlincode.annotation.Aggregate
import java.time.LocalDateTime

@Aggregate
data class Feed(
        val id: Long,

        val title: String,

        val content: String,

        val isCompleted: Boolean,

        val userId: Long,

        val createdAt: LocalDateTime

)
