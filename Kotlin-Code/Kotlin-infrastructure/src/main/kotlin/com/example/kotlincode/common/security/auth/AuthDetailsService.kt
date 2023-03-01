package com.example.kotlincode.common.security.auth

import com.example.kotlincode.user.persistence.UserRepository
import com.example.kotlincode.user.persistence.entity.UserEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
        private val userRepository: UserRepository

) : UserDetailsService {

    override fun loadUserByUsername(accountId: String): UserDetails {
        val user: UserEntity = userRepository.findByAccountId(accountId)
        return AuthDetails(user)
    }

}