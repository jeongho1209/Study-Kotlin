package com.example.kotlin.domain.feed.domain.repository

import com.example.kotlin.domain.feed.domain.Feed
import org.springframework.data.repository.CrudRepository

interface FeedRepository : CrudRepository<Feed, Long>, CustomFeedRepository {

}