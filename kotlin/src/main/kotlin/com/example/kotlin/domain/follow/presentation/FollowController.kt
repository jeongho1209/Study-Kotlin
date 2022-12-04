package com.example.kotlin.domain.follow.presentation

import com.example.kotlin.domain.follow.presentation.request.CreateFollowRequest
import com.example.kotlin.domain.follow.presentation.response.FollowResponse
import com.example.kotlin.domain.follow.service.CreateFollowService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/follow")
@RestController
class FollowController(
        private val createFollowService: CreateFollowService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createFollow(@RequestBody @Valid request: CreateFollowRequest): FollowResponse {
        return createFollowService.execute(request)
    }

}