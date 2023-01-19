package com.example.kotlin.domain.auth.service

import com.example.kotlin.domain.user.domain.User
import com.example.kotlin.domain.user.domain.UserRepository
import com.example.kotlin.domain.user.exception.InvalidEmailException
import com.example.kotlin.domain.user.exception.UserExistException
import com.example.kotlin.domain.user.facade.UserFacade
import com.example.kotlin.domain.user.presentation.dto.response.TokenResponse
import com.example.kotlin.global.security.jwt.JwtTokenProvider
import com.example.kotlin.infrastructure.feign.client.GoogleInfoClient
import com.example.kotlin.infrastructure.feign.client.GoogleTokenClient
import com.example.kotlin.infrastructure.feign.dto.request.GoogleCodeRequest
import com.example.kotlin.infrastructure.feign.properties.GoogleFeignProperties
import org.springframework.stereotype.Service
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Service
class GoogleAuthService(
    private val googleInfoClient: GoogleInfoClient,
    private val googleTokenClient: GoogleTokenClient,
    private val googleFeignProperties: GoogleFeignProperties,
    private val jwtTokenProvider: JwtTokenProvider,
    private val userRepository: UserRepository,
    private val userFacade: UserFacade
) {

    companion object {
        private const val SCHOOL_EMAIL = "@dsm.hs.kr"
    }

    fun execute(code: String): TokenResponse {
        val accessToken = googleTokenClient.googleAuth(
            GoogleCodeRequest(
                code = URLDecoder.decode(code, StandardCharsets.UTF_8),
                clientId = googleFeignProperties.clientId,
                clientSecret = googleFeignProperties.clientSecret,
                redirectUri = googleFeignProperties.redirectUri
            )
        ).accessToken

        val googleInfoResponse = googleInfoClient.getUserInfo(accessToken)

        val email = googleInfoResponse.email

        createUser(email)

        return jwtTokenProvider.getToken(email)
    }

    private fun createUser(email: String) {
        if (userFacade.checkExistUser(email)) {
            throw UserExistException.EXCEPTION
        }

        if (!email.endsWith(SCHOOL_EMAIL)) {
            throw InvalidEmailException.EXCEPTION
        }

        val user = userRepository.findByEmail(email)
            ?: User(
                id = 0,
                email = email,
                password = null,
                followedCounts = 0,
                followingCounts = 0
            )

        userRepository.save(user)
    }

}