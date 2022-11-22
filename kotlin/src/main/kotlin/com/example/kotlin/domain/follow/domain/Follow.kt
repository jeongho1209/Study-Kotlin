package com.example.kotlin.domain.follow.domain

import com.example.kotlin.domain.user.domain.User
import com.example.kotlin.global.entity.BaseIdEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Follow(
        override val id: Long,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "target_user_id", nullable = false)
        val targetUser: User
) : BaseIdEntity()