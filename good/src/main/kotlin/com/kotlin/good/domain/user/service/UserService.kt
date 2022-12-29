package com.kotlin.good.domain.user.service

import com.kotlin.good.domain.user.domain.repository.UserRepository
import com.kotlin.good.domain.user.error.exception.PasswordMisMatch
import com.kotlin.good.domain.user.error.exception.UserNotFound
import com.kotlin.good.domain.user.presentation.dto.request.UserSignInRequest
import com.kotlin.good.domain.user.presentation.dto.response.TokenResponse
import com.kotlin.good.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {

    fun execute(request: UserSignInRequest): TokenResponse {
        val user = userRepository.findByEmail(request.email)
            ?: throw UserNotFound.EXCEPTION

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMisMatch.EXCEPTION
        }

        return jwtTokenProvider.getToken(request.email)
    }

}