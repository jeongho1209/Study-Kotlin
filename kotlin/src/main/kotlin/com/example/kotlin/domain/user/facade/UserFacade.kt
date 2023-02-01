package com.example.kotlin.domain.user.facade

import com.example.kotlin.domain.user.domain.User
import com.example.kotlin.domain.user.domain.UserRepository
import com.example.kotlin.domain.user.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {

    fun getByEmail(email: String): User {
        return userRepository.findByEmail(email)
            ?: throw UserNotFoundException.EXCEPTION
    }

    fun getCurrentUser(): User {
        val userEmail = SecurityContextHolder.getContext().authentication.name
        return getByEmail(userEmail)
    }

    fun getUserById(userId: Long): User = userRepository.findByIdOrNull(userId)
        ?: throw UserNotFoundException.EXCEPTION

    fun checkExistUser(email: String): Boolean {
        return userRepository.existsByEmail(email)
    }

}