package com.example.kotlin.domain.feed.service

import com.example.kotlin.domain.feed.exception.CannotUpdateFeedException
import com.example.kotlin.domain.feed.facade.FeedFacade
import com.example.kotlin.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.kotlin.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateFeedService(
        private val userFacade: UserFacade,
        private val feedFacade: FeedFacade,
) {

    @Transactional
    fun execute(feedId: Long, request: UpdateFeedRequest) {
        val user = userFacade.getCurrentUser()
        val feed = feedFacade.getFeed(feedId)

        if (user != feed.user) {
            throw CannotUpdateFeedException.EXCEPTION
        }

        feed.updateFeed(request.title,
                request.content)
    }

}