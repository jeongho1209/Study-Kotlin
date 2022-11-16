package com.example.kotlin.domain.feed.service

import com.example.kotlin.domain.feed.domain.Feed
import com.example.kotlin.domain.feed.domain.FeedRepository
import com.example.kotlin.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.kotlin.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class CreateFeedService(
        private val feedRepository: FeedRepository,
        private val userFacade: UserFacade
) {

    @Transactional
    fun execute(request: CreateFeedRequest) {
        val user = userFacade.getCurrentUser()

        feedRepository.save(
                Feed(
                        id = null,
                        title = request.title,
                        content = request.content,
                        user = user,
                        createdAt = LocalDateTime.now()
                ));
    }

}