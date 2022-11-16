package com.example.kotlin.domain.feed.presentation

import com.example.kotlin.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.kotlin.domain.feed.service.CreateFeedService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/feed")
@RestController
class FeedController(
        private val createFeedService: CreateFeedService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createFeed(@RequestBody @Valid request: CreateFeedRequest) {
        createFeedService.execute(request)
    }

}