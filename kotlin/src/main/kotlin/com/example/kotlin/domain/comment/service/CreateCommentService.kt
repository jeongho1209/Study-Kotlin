package com.example.kotlin.domain.comment.service

import com.example.kotlin.domain.comment.domain.Comment
import com.example.kotlin.domain.comment.domain.CommentRepository
import com.example.kotlin.domain.comment.presentation.request.CreateCommentRequest
import com.example.kotlin.domain.feed.facade.FeedFacade
import com.example.kotlin.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class CreateCommentService(
        private val feedFacade: FeedFacade,
        private val userFacade: UserFacade,
        private val commentRepository: CommentRepository
) {

    @Transactional
    fun execute(feedId: Long, request: CreateCommentRequest) {
        val feed = feedFacade.getFeed(feedId)
        val user = userFacade.getCurrentUser()

        commentRepository.save(
                Comment(
                        id = 0,
                        content = request.content,
                        feed = feed,
                        user = user,
                        createdAt = LocalDateTime.now()
                )
        )
    }

}