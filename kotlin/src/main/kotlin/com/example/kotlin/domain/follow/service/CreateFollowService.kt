package com.example.kotlin.domain.follow.service

import com.example.kotlin.domain.follow.domain.Follow
import com.example.kotlin.domain.follow.domain.FollowRepository
import com.example.kotlin.domain.follow.exception.CannotFollowYourselfException
import com.example.kotlin.domain.follow.exception.FollowExistException
import com.example.kotlin.domain.follow.facade.FollowFacade
import com.example.kotlin.domain.follow.presentation.request.CreateFollowRequest
import com.example.kotlin.domain.follow.presentation.response.FollowResponse
import com.example.kotlin.domain.user.domain.User
import com.example.kotlin.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateFollowService(
        private val userFacade: UserFacade,
        private val followFacade: FollowFacade,
        private val followRepository: FollowRepository
) {

    @Transactional
    fun execute(request: CreateFollowRequest): FollowResponse {
        val user = userFacade.getCurrentUser()

        val targetUser = userFacade.getUserById(request.targetUserId)

        if (user == targetUser) {
            throw CannotFollowYourselfException.EXCEPTION
        }

        if (followFacade.checkFollowed(user, targetUser)) {
            throw FollowExistException.EXCEPTION
        }

        targetUser.addFollower()
        user.addFollowing()
        return addFollow(user, targetUser)
    }

    private fun addFollow(user: User, targetUser: User): FollowResponse {
        followRepository.save(
                Follow(
                        id = 0,
                        user = user,
                        targetUser = targetUser
                )
        )

        return FollowResponse(
                followed = followFacade.checkFollowed(user, targetUser),
                followCounts = user.followedCounts
        )
    }
}