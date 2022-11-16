package com.example.kotlin.domain.feed.domain

import com.example.kotlin.domain.user.domain.User
import com.example.kotlin.global.entity.BaseTimeEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Feed(
        id: Long?,
        title: String,
        content: String,
        override val createdAt: LocalDateTime,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User
) : BaseTimeEntity(createdAt) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = id

    var title = title
        protected set

    var content = content
        protected set
}