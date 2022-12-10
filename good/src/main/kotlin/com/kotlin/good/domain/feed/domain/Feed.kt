package com.kotlin.good.domain.feed.domain

import com.kotlin.good.domain.user.domain.User
import com.kotlin.good.global.entity.BaseUUIDEntity
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "tbl_feed")
class Feed(
        override val id: UUID,

        @field:NotNull
        @Column(columnDefinition = "VARCHAR(20)")
        val title: String,

        @field:NotNull
        @Column(columnDefinition = "VARCHAR(1000)")
        val content: String,

        @field:NotNull
        @ColumnDefault("'0'")
        val viewCounts: Int,

        @field:NotNull
        val createdAt: LocalDateTime,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User
) : BaseUUIDEntity()