package com.example.kotlin.domain.feed.service

import com.example.kotlin.domain.feed.domain.FeedRepository
import com.example.kotlin.domain.feed.exception.CannotDeleteFeedException
import com.example.kotlin.domain.feed.facade.FeedFacade
import com.example.kotlin.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteFeedService(
        private val feedFacade: FeedFacade,
        private val userFacade: UserFacade,
        private val feedRepository: FeedRepository
) {

    @Transactional
    fun execute(feedId: Long) {
        val user = userFacade.getCurrentUser()
        val feed = feedFacade.getFeed(feedId)

        if (user != feed.user) {
            throw CannotDeleteFeedException.EXCEPTION
        }

        feedRepository.delete(feed)
    }

}