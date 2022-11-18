package com.example.kotlincode.domain.user.persistence.entity

import com.example.kotlincode.global.entity.BaseIdEntity
import org.hibernate.validator.constraints.Length
import javax.persistence.Column
import javax.persistence.Entity
import javax.validation.constraints.NotNull

@Entity
class UserEntity(
        override val id: Long,

        @field:NotNull
        @Column(unique = true)
        @Length(max = 20)
        val accountId: String,

        password: String,
        username: String
) : BaseIdEntity() {

    @field:NotNull
    @Length(max = 60)
    var password: String = password
        protected set

    @field:NotNull
    @Length(max = 8)
    var username: String = username
        protected set

}