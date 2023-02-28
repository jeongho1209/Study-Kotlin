package com.example.kotlincode.feed

import com.example.kotlincode.common.annotation.Aggregate
import java.time.LocalDateTime

@Aggregate
data class Feed(
        val id: Long = 0,

        val title: String,

        val content: String,

        val isCompleted: Boolean,

        val userId: Long,

        val createdAt: LocalDateTime,

)
