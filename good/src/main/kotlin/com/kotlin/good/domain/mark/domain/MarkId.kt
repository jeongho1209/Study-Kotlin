package com.kotlin.good.domain.mark.domain

import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.validation.constraints.NotNull

@Embeddable
data class MarkId(
    @field:NotNull
    @Column(columnDefinition = "BINARY(16)")
    val user: UUID,

    @field:NotNull
    @Column(columnDefinition = "BINARY(16)")
    val item: UUID
) : Serializable
