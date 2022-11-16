package com.example.kotlin.domain.user.service

import com.example.kotlin.domain.user.domain.UserRepository
import com.example.kotlin.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserWithdrawalService(
        private val userFacade: UserFacade,
        private val userRepository: UserRepository,
) {

    @Transactional
    fun execute() {
        val user = userFacade.getCurrentUser()

        userRepository.delete(user)
    }

}