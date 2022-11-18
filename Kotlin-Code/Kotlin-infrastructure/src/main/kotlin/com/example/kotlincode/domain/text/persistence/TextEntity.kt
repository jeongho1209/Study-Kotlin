package com.example.kotlincode.domain.text.persistence

import com.example.kotlincode.domain.user.persistence.entity.UserEntity
import com.example.kotlincode.global.entity.BaseIdEntity
import org.hibernate.validator.constraints.Length
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

@Entity
class TextEntity(
        override val id: Long,

        text: String,

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val userEntity: UserEntity
) : BaseIdEntity() {

    @field:NotNull
    @Length(max = 5000)
    var text: String = text
        protected set

}