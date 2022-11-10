package com.example.kotlin.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UserSignUpRequest(

        @NotBlank
        @Size(min = 8, max = 20)
        val accountId: String,

        @NotBlank
        @Size(min = 20, max = 20)
        val password: String
)
