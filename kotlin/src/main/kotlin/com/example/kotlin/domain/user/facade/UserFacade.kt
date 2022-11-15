package com.example.kotlin.domain.user.facade

import com.example.kotlin.domain.user.domain.User
import com.example.kotlin.domain.user.domain.UserRepository
import com.example.kotlin.domain.user.exception.UserNotFoundException
import org.springframework.stereotype.Component

@Component
class UserFacade(
        private val userRepository: UserRepository
) {
    fun getByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException.EXCEPTION
    }

}