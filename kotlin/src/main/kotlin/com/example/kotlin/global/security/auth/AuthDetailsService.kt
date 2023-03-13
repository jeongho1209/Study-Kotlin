package com.example.kotlin.global.security.auth

import com.example.kotlin.domain.user.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userFacade: UserFacade
) : UserDetailsService {

    override fun loadUserByUsername(accountId: String): UserDetails {
        val user = userFacade.getByEmail(accountId)

        return AuthDetails(user)
    }
}
