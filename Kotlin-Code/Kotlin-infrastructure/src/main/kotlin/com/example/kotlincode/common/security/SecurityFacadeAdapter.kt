package com.example.kotlincode.common.security

import com.example.kotlincode.user.User
import com.example.kotlincode.user.mapper.UserMapper
import com.example.kotlincode.user.persistence.UserRepository
import com.example.kotlincode.user.spi.UserSecuritySpi
import com.example.kotlincode.common.annotation.Adapter
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