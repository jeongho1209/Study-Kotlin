package com.example.kotlin.domain.feed.domain

import com.example.kotlin.domain.user.domain.User
import com.example.kotlin.global.entity.BaseIdEntity
import org.hibernate.validator.constraints.Length
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull

@Entity
class Feed(

        override val id: Long,

        title: String,
        content: String,

        @field:NotNull
        @CreatedDate
        val createdAt: LocalDateTime = LocalDateTime.now(),

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User
) : BaseIdEntity() {

    @field:NotNull
    @Length(max = 20)
    var title = title
        protected set

    @field:NotNull
    @Length(max = 1000)
    var content = content
        protected set

    fun updateFeed(title: String, content: String) {
        this.title = title
        this.content = content
    }

}