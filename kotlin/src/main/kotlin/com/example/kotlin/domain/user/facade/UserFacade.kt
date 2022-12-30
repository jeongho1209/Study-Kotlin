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

    fun getByEmail(accountId: String): User {
        return userRepository.findByEmail(accountId) ?: throw UserNotFoundException.EXCEPTION
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