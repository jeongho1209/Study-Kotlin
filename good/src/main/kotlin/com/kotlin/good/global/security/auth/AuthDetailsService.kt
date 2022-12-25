package com.kotlin.good.global.security.auth

import com.kotlin.good.domain.user.domain.repository.UserRepository
import com.kotlin.good.domain.user.error.exception.UserNotFound
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*

@Component
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(userId: String): UserDetails {
        val id = UUID.fromString(userId)
        val user = userRepository.findByIdOrNull(id) ?: throw UserNotFound.EXCEPTION

        return AuthDetails(id, user.authority)
    }

}