package com.example.kotlin.infrastructure.feign.client

import com.example.kotlin.infrastructure.feign.dto.request.GoogleCodeRequest
import com.example.kotlin.infrastructure.feign.dto.response.TokenResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(name = "GoogleAuthClient", url = "https://oauth2.googleapis.com/token")
interface GoogleTokenClient {

    @PostMapping
    fun googleAuth(googleCodeRequest: GoogleCodeRequest): TokenResponse

}