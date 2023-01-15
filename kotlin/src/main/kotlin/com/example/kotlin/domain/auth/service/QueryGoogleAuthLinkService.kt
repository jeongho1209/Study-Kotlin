package com.example.kotlin.domain.auth.service

import com.example.kotlin.domain.auth.presentation.dto.response.LinkResponse
import com.example.kotlin.infrastructure.feign.properties.GoogleFeignProperties
import org.springframework.stereotype.Service

@Service
class QueryGoogleAuthLinkService(
        private val feignProperties: GoogleFeignProperties
) {

    companion object {
        const val GOOGLE_LINK = "%s?client_id=%s&redirect_uri=%s&response_type=code" +
                "&scope=https://www.googleapis.com/auth/userinfo.email"
    }

    fun execute(): LinkResponse {
        return LinkResponse(
                queryLink()
        )
    }

    private fun queryLink(): String {
        return String.format(
                GOOGLE_LINK,
                feignProperties.baseUrl,
                feignProperties.clientId,
                feignProperties.redirectUri
        )
    }

}