package com.example.kotlin.domain.feed.service

import com.example.kotlin.domain.feed.domain.Feed
import com.example.kotlin.domain.feed.domain.repository.FeedRepository
import com.example.kotlin.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.kotlin.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CreateFeedService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade
) {

    fun execute(request: CreateFeedRequest) {
        feedRepository.save(
            Feed(
                id = 0,
                title = request.title,
                content = request.content,
                user = userFacade.getCurrentUser(),
                createdAt = LocalDateTime.now()
            )
        )
    }
}