package com.example.kotlincode.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

data class WebUserSignUpRequest(
        @NotBlank
        val accountId: String,

        @NotBlank
        val password: String,

        @NotBlank
        val username: String
)
