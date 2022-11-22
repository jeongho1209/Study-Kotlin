package com.example.kotlin.domain.feed.presentation

import com.example.kotlin.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.kotlin.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.kotlin.domain.feed.presentation.dto.response.QueryFeedListResponse
import com.example.kotlin.domain.feed.service.CreateFeedService
import com.example.kotlin.domain.feed.service.DeleteFeedService
import com.example.kotlin.domain.feed.service.QueryFeedListService
import com.example.kotlin.domain.feed.service.UpdateFeedService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/feed")
@RestController
class FeedController(
        private val createFeedService: CreateFeedService,
        private val deleteFeedService: DeleteFeedService,
        private val updateFeedService: UpdateFeedService,
        private val queryFeedListService: QueryFeedListService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createFeed(@RequestBody @Valid request: CreateFeedRequest) {
        createFeedService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    fun deleteFeed(@PathVariable("feed-id") feedId: Long) {
        deleteFeedService.execute(feedId)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{feed-id}")
    fun updateFeed(@PathVariable("feed-id") feedId: Long,
                   @RequestBody @Valid request: UpdateFeedRequest) {
        updateFeedService.execute(feedId, request)
    }

    @GetMapping
    fun queryFeedList(): QueryFeedListResponse {
        return queryFeedListService.execute()
    }

}