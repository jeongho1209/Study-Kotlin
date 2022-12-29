package com.kotlin.good.domain.user.presentation

import com.kotlin.good.domain.user.presentation.dto.request.UserSignInRequest
import com.kotlin.good.domain.user.presentation.dto.response.TokenResponse
import com.kotlin.good.domain.user.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping("/token")
    fun signIn(@RequestBody request: UserSignInRequest): TokenResponse {
        return userService.execute(request)
    }

}