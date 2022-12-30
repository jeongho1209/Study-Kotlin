package com.example.kotlin.domain.comment.domain

import com.example.kotlin.domain.feed.domain.Feed
import com.example.kotlin.domain.user.domain.User
import com.example.kotlin.global.entity.BaseIdEntity
import org.hibernate.validator.constraints.Length
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull

@Entity
class Comment(
        override val id: Long,

        val createdAt: LocalDateTime,

        content: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "feed_id", nullable = false)
        val feed: Feed
) : BaseIdEntity() {

    @field:NotNull
    @Length(max = 500)
    var content: String = content

}