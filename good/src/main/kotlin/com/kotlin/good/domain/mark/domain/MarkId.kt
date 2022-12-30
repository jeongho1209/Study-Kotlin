package com.kotlin.good.domain.mark.domain

import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable
import javax.validation.constraints.NotNull

@Embeddable
data class MarkId(
    @field:NotNull
    val userId: UUID,

    @field:NotNull
    val itemId: UUID
) : Serializable
