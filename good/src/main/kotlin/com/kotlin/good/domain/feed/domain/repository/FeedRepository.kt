package com.kotlin.good.domain.feed.domain.repository

import com.kotlin.good.domain.feed.domain.Feed
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FeedRepository : JpaRepository<Feed, UUID> {
}