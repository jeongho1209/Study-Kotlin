package com.example.kotlincode.domain.user.presentation

import com.example.kotlincode.domain.user.api.UserSignUpApi
import com.example.kotlincode.domain.user.api.dto.DomainUserSignUpRequest
import com.example.kotlincode.domain.user.presentation.dto.request.WebUserSignUpRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/user")
@RestController
class UserWebAdapter(
        private val userSignUpApi: UserSignUpApi,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid request: WebUserSignUpRequest) {
        userSignUpApi.execute(DomainUserSignUpRequest(
                accountId = request.accountId,
                password = request.password,
                username = request.username
        ))
    }

}