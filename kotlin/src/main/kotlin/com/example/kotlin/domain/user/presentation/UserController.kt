package com.example.kotlin.domain.user.presentation

import com.example.kotlin.domain.user.presentation.dto.request.UserSignInRequest
import com.example.kotlin.domain.user.presentation.dto.request.UserSignUpRequest
import com.example.kotlin.domain.user.service.UserSignInService
import com.example.kotlin.domain.user.service.UserSignUpService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/user")
@RestController
class UserController(
        private val userSignInService: UserSignInService,
        private val userSignUpService: UserSignUpService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid request: UserSignUpRequest) {
        userSignUpService.execute(request)
    }

    @PostMapping("/token")
    fun signIn(@RequestBody @Valid request: UserSignInRequest) {
        userSignInService.signIn(request)
    }

}