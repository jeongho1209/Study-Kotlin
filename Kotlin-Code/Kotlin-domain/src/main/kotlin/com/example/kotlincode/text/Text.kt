package com.example.kotlincode.text

import com.example.kotlincode.common.annotation.Aggregate

@Aggregate
data class Text(
        val id: Long = 0,

        val text: String,

        val user: Long,

)
