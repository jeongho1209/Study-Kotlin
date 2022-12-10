package com.kotlin.good.domain.follow.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.validation.constraints.NotNull
import java.io.Serializable
import java.util.*

@Embeddable
data class FollowId(
        @field:NotNull
        @Column(columnDefinition = "BINARY(16)")
        val user: UUID,

        @field:NotNull
        @Column(columnDefinition = "BINARY(16)")
        val targetUser: UUID
) : Serializable
