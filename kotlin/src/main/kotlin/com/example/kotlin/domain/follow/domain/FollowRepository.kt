package com.example.kotlin.domain.follow.domain

import com.example.kotlin.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FollowRepository : CrudRepository<Follow, Long> {

    fun existsByUserAndTargetUser(user: User, targetUser: User): Boolean

}