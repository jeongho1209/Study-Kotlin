package com.example.kotlin.domain.feed.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateFeedRequest(

        @NotBlank
        @Size(max = 20)
        val title: String,

        @NotBlank
        @Size(max = 20)
        val content: String
)
