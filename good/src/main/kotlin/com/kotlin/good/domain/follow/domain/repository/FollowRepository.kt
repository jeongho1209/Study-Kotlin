package com.kotlin.good.domain.follow.domain.repository

import com.kotlin.good.domain.follow.domain.Follow
import com.kotlin.good.domain.follow.domain.FollowId
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FollowRepository : CrudRepository<Follow, FollowId> {
}