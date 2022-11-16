package com.example.kotlin.domain.feed.facade

import com.example.kotlin.domain.feed.domain.Feed
import com.example.kotlin.domain.feed.domain.FeedRepository
import com.example.kotlin.domain.feed.exception.FeedNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class FeedFacade(
        private val feedRepository: FeedRepository
) {

    fun getFeed(feedId: Long): Feed {
        return feedRepository.findByIdOrNull(feedId) ?: throw FeedNotFoundException.EXCEPTION
    }

}