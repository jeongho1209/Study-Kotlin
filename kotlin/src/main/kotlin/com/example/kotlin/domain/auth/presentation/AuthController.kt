package com.example.kotlin.domain.auth.presentation

import com.example.kotlin.domain.auth.presentation.dto.response.LinkResponse
import com.example.kotlin.domain.auth.service.GoogleAuthService
import com.example.kotlin.domain.auth.service.QueryGoogleAuthLinkService
import com.example.kotlin.domain.user.presentation.dto.response.TokenResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("/auth")
@RestController
class AuthController(
        private val googleAuthService: GoogleAuthService,
        private val queryGoogleAuthLinkService: QueryGoogleAuthLinkService
) {

    @GetMapping("/google")
    fun googleAuth(@RequestParam code: String): TokenResponse {
        return googleAuthService.execute(code)
    }

    @GetMapping("/google/auth")
    fun queryGoogleAuthLink(): LinkResponse {
        return queryGoogleAuthLinkService.execute()
    }

}