package com.kotlin.good.domain.feed.domain

import com.kotlin.good.domain.user.domain.User
import com.kotlin.good.global.entity.BaseUUIDEntity
import org.hibernate.annotations.ColumnDefault
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

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
        @CreatedDate
        val createdAt: LocalDateTime,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User
) : BaseUUIDEntity()