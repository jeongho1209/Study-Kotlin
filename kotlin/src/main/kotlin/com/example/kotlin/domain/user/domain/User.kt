package com.example.kotlin.domain.user.domain

import com.example.kotlin.global.entity.BaseIdEntity
import org.hibernate.validator.constraints.Length
import javax.persistence.Column
import javax.persistence.Entity
import javax.validation.constraints.NotNull

@Entity
class User(

        override val id: Long,

        @field:NotNull
        @Length(max = 20)
        @Column(unique = true)
        val accountId: String,

        password: String
) : BaseIdEntity() {

    @field:NotNull
    @Length(max = 60)
    var password: String = password
        protected set

}
