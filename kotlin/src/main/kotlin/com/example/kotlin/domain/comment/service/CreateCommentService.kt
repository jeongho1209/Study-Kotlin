package com.example.kotlin.domain.comment.service

import com.example.kotlin.domain.comment.domain.Comment
import com.example.kotlin.domain.comment.domain.CommentRepository
import com.example.kotlin.domain.comment.presentation.request.CreateCommentRequest
import com.example.kotlin.domain.feed.facade.FeedFacade
import com.example.kotlin.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CreateCommentService(
    private val feedFacade: FeedFacade,
    private val userFacade: UserFacade,
    private val commentRepository: CommentRepository
) {

    fun execute(feedId: Long, request: CreateCommentRequest) {
        commentRepository.save(
            Comment(
                id = 0,
                content = request.content,
                feed = feedFacade.getFeed(feedId),
                user = userFacade.getCurrentUser(),
                createdAt = LocalDateTime.now()
            )
        )
    }
}
