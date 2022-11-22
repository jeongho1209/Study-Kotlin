package com.example.kotlin.domain.feed.service

import com.example.kotlin.domain.feed.domain.FeedRepository
import com.example.kotlin.domain.feed.presentation.dto.response.FeedElement
import com.example.kotlin.domain.feed.presentation.dto.response.QueryFeedListResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryFeedListService(
        private val feedRepository: FeedRepository
) {

    @Transactional(readOnly = true)
    fun execute(): QueryFeedListResponse {
        val feedList: List<FeedElement> = feedRepository.findAllByOrderByCreatedAtDesc()
                .map {
                    FeedElement(
                            feedId = it.id,
                            title = it.title,
                            content = it.content,
                            createdAt = it.createdAt
                    )
                }
                .toList()
        return QueryFeedListResponse(
                feedList = feedList
        )
    }

}