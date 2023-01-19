package com.example.kotlincode.global.security

import com.example.kotlincode.domain.user.domain.User
import com.example.kotlincode.domain.user.mapper.UserMapper
import com.example.kotlincode.domain.user.persistence.UserRepository
import com.example.kotlincode.domain.user.spi.UserSecuritySpi
import com.example.kotlincode.global.annotation.Adapter
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder

@Adapter
class SecurityFacadeAdapter(
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : UserSecuritySpi {

    override fun encodePassword(password: String): String {
        return passwordEncoder.encode(password)
    }

    override fun matches(rawPassword: String, newPassword: String): Boolean {
        return passwordEncoder.matches(rawPassword, newPassword)
    }

    override fun getCurrentUserId(): User {
        val accountId = SecurityContextHolder.getContext().authentication.name
        return userMapper.toDomain(userRepository.findByAccountId(accountId))
    }

}