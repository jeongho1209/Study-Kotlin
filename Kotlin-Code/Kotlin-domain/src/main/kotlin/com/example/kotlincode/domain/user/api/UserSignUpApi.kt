package com.example.kotlincode.domain.user.api

import com.example.kotlincode.domain.user.api.dto.DomainUserSignUpRequest

interface UserSignUpApi {

    fun execute(request: DomainUserSignUpRequest)

}