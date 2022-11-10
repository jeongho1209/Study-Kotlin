package com.example.kotlin.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

data class UserSignInRequest(

        @NotBlank
        val accountId: String,

        @NotBlank
        val password: String
)
