package com.kotlin.good.domain.follow.domain

import com.kotlin.good.domain.user.domain.User
import jakarta.persistence.*

@Entity
@Table(name = "tbl_follow")
class Follow(
        @EmbeddedId
        val id: FollowId,

        @MapsId("user")
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User,

        @MapsId("targetUser")
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "target_user_id", nullable = false)
        val targetUser: User
)