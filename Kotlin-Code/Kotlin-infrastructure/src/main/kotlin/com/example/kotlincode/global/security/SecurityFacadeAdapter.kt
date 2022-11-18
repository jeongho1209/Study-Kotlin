package com.example.kotlincode.global.security

import com.example.kotlincode.domain.user.spi.UserSecuritySpi
import com.example.kotlincode.global.annotation.Adapter
import org.springframework.security.crypto.password.PasswordEncoder

@Adapter
class SecurityFacadeAdapter(
        private val passwordEncoder: PasswordEncoder,
) : UserSecuritySpi {

    override fun encodePassword(password: String): String {
        return passwordEncoder.encode(password)
    }

}