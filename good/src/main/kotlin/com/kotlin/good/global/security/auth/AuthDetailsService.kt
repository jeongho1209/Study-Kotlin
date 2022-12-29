package com.kotlin.good.global.security.auth

import com.kotlin.good.domain.user.domain.repository.UserRepository
import com.kotlin.good.domain.user.error.exception.UserNotFound
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository.findByEmail(email)
            ?: throw UserNotFound.EXCEPTION

        return AuthDetails(user)
    }

}