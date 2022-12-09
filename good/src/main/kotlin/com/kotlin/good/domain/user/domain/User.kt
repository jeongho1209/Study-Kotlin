package com.kotlin.good.domain.user.domain

import com.kotlin.good.global.entity.BaseUUIDEntity
import com.kotlin.good.global.enum.Authority
import com.kotlin.good.global.enum.Sex
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.util.*

@Entity
@Table(name = "tbl_user")
class User(
        override val id: UUID,

        @field:NotNull
        @Column(columnDefinition = "VARCHAR(64)", unique = true)
        val email: String,

        @field:NotNull
        @Column(columnDefinition = "CHAR(60)")
        val password: String,

        @field:NotNull
        @Column(columnDefinition = "VARCHAR(10)")
        val name: String,

        @field:NotNull
        @Enumerated(EnumType.STRING)
        @Column(columnDefinition = "VARCHAR(5)")
        val authority: Authority,

        @field:NotNull
        @Enumerated(EnumType.STRING)
        @Column(columnDefinition = "VARCHAR(6)")
        val sex: Sex,

        @Column(columnDefinition = "VARCHAR(50)")
        val introduce: String?
) : BaseUUIDEntity()