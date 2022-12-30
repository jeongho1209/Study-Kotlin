package com.example.kotlin.domain.comment.presentation.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateCommentRequest(
        @NotBlank
        @Size(max = 500)
        val content: String
)
