package com.example.kotlincode.domain.text.domain

import com.example.kotlincode.annotation.Aggregate

@Aggregate
data class Text(
        val id: Long = 0,

        val text: String,

        val user: Long,

)
