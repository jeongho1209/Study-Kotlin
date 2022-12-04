package com.example.kotlin.domain.follow.presentation.request

import javax.validation.constraints.NotNull

data class CreateFollowRequest(

        @NotNull
        val targetUserId: Long
)
