package com.example.kotlin.domain.user.presentation

import com.example.kotlin.domain.user.presentation.dto.request.UserSignInRequest
import com.example.kotlin.domain.user.presentation.dto.request.UserSignUpRequest
import com.example.kotlin.domain.user.presentation.dto.response.TokenResponse
import com.example.kotlin.domain.user.service.UserSignInService
import com.example.kotlin.domain.user.service.UserSignUpService
import com.example.kotlin.domain.user.service.UserWithdrawalService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/user")
@RestController
class UserController(
        private val userSignInService: UserSignInService,
        private val userSignUpService: UserSignUpService,
        private val userWithdrawalService: UserWithdrawalService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid request: UserSignUpRequest) {
        userSignUpService.execute(request)
    }

    @PostMapping("/token")
    fun signIn(@RequestBody @Valid request: UserSignInRequest): TokenResponse {
        return userSignInService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    fun deleteUser() {
        userWithdrawalService.execute()
    }

}