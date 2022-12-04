package com.example.kotlin.domain.follow.facade

import com.example.kotlin.domain.follow.domain.FollowRepository
import com.example.kotlin.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class FollowFacade(
        private val followRepository: FollowRepository
) {
    fun checkFollowed(user: User, targetUser: User) : Boolean {
        return followRepository.existsByUserAndTargetUser(user, targetUser)
    }

}