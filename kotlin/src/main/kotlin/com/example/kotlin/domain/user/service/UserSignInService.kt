package com.example.kotlin.domain.user.service

import com.example.kotlin.domain.user.domain.UserRepository
import com.example.kotlin.domain.user.exception.PasswordMisMatchException
import com.example.kotlin.domain.user.facade.UserFacade
import com.example.kotlin.domain.user.presentation.dto.request.UserSignInRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserSignInService(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder,
        private val userFacade: UserFacade
) {

    fun signIn(request: UserSignInRequest): String {
        val user = userFacade.getByAccountId(request.accountId)

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMisMatchException.EXCEPTION
        }

        return "success"
    }

}