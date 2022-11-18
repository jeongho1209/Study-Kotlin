package com.example.kotlincode.domain.feed.persistence.entity

import com.example.kotlincode.domain.user.persistence.entity.UserEntity
import com.example.kotlincode.global.entity.BaseIdEntity
import org.hibernate.validator.constraints.Length
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_feed")
class FeedEntity(
        override val id: Long,

        @field:NotNull
        @CreatedDate
        val createdAt: LocalDateTime,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val userEntity: UserEntity,

        title: String,
        content: String,
        isCompleted: Boolean
) : BaseIdEntity() {

    @field:NotNull
    @Length(max = 20)
    var title: String = title
        protected set

    @field:NotNull
    @Length(max = 1000)
    var content: String = content
        protected set

    @field:NotNull
    var isCompleted: Boolean = isCompleted

}

