package com.example.kotlin.domain.user.service

import com.example.kotlin.domain.user.exception.PasswordMisMatchException
import com.example.kotlin.domain.user.facade.UserFacade
import com.example.kotlin.domain.user.presentation.dto.request.UserSignInRequest
import com.example.kotlin.domain.user.presentation.dto.response.TokenResponse
import com.example.kotlin.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserSignInService(
        private val jwtTokenProvider: JwtTokenProvider,
        private val passwordEncoder: PasswordEncoder,
        private val userFacade: UserFacade
) {

    fun execute(request: UserSignInRequest): TokenResponse {
        val user = userFacade.getByEmail(request.email)

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMisMatchException.EXCEPTION
        }

        return jwtTokenProvider.getToken(request.email)
    }

}