package com.example.kotlin.domain.comment.presentation

import com.example.kotlin.domain.comment.presentation.request.CreateCommentRequest
import com.example.kotlin.domain.comment.service.CreateCommentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/comment")
@RestController
class CommentController(
        private val createCommentService: CreateCommentService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    fun createComment(@PathVariable("feed-id") feedId: Long,
                      @RequestBody @Valid request: CreateCommentRequest) {
        createCommentService.execute(feedId, request)
    }

}