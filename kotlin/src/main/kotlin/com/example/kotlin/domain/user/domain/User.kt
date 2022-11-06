package com.example.kotlin.domain.user.domain

import com.example.kotlin.global.entity.BaseIdEntity
import org.hibernate.validator.constraints.Length
import javax.persistence.Entity
import javax.validation.constraints.NotNull

@Entity
class User(

        @NotNull
        override val id: Long,

        @NotNull
        @Length(max = 20)
        val accountId: String,

        @NotNull
        @Length(max = 60)
        val password: String

) : BaseIdEntity(id)