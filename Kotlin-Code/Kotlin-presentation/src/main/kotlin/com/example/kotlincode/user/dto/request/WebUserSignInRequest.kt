package com.example.kotlincode.user.dto.request

import javax.validation.constraints.NotBlank

data class WebUserSignInRequest(
        @NotBlank
        val accountId: String,

        @NotBlank
        val password: String // TODO: Web 제거하기
)
