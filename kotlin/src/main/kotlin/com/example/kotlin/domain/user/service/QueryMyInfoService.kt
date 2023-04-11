package com.example.kotlin.domain.user.service

import com.example.kotlin.domain.user.facade.UserFacade
import com.example.kotlin.domain.user.presentation.dto.response.QueryMyInfoResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryMyInfoService(
    private val userFacade: UserFacade
) {

    @Transactional(readOnly = true)
    fun execute(): QueryMyInfoResponse {
        val user = userFacade.getCurrentUser()
        return QueryMyInfoResponse(
            followingCounts = user.followingCounts,
            followedCounts = user.followedCounts,
        )
    }
}
