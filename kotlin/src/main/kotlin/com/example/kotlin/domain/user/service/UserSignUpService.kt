package com.example.kotlin.domain.user.service

import com.example.kotlin.domain.user.domain.User
import com.example.kotlin.domain.user.domain.UserRepository
import com.example.kotlin.domain.user.exception.UserExistException
import com.example.kotlin.domain.user.facade.UserFacade
import com.example.kotlin.domain.user.presentation.dto.request.UserSignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserSignUpService(
        private val userFacade: UserFacade,
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun execute(request: UserSignUpRequest) {
        if (userFacade.checkExistUser(request.accountId)) {
            throw UserExistException.EXCEPTION
        }

        userRepository.save(
                User(
                        id = 0,
                        accountId = request.accountId,
                        password = passwordEncoder.encode(request.password))
        )
    }

}