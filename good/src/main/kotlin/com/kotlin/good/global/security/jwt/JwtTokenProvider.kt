package com.kotlin.good.global.security.jwt

import com.kotlin.good.domain.refresh_token.domain.RefreshToken
import com.kotlin.good.domain.refresh_token.domain.repository.RefreshTokenRepository
import com.kotlin.good.domain.user.presentation.dto.response.TokenResponse
import com.kotlin.good.global.security.SecurityProperty
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class JwtTokenProvider(
    private val securityProperty: SecurityProperty,
    private val refreshTokenRepository: RefreshTokenRepository,
) {

    private fun createAccessToken(email: String) =
        generateToken(email, JwtProperty.ACCESS, securityProperty.accessExp)

    private fun createRefreshToken(email: String): String {
        val token = generateToken(email, JwtProperty.REFRESH, securityProperty.refreshExp)

        refreshTokenRepository.save(
            RefreshToken(
                token = token,
                email = email,
                expiredAt = securityProperty.refreshExp
            )
        )
        return token
    }

    private fun generateToken(email: String, type: String, expiredAt: Long) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, securityProperty.secretKey)
            .setSubject(email)
            .setHeaderParam(Header.JWT_TYPE, type)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiredAt * 1000))
            .compact()

    fun getToken(email: String) = TokenResponse(
        accessToken = createAccessToken(email),
        refreshToken = createRefreshToken(email),
        accessTokenExp = LocalDateTime.now().plusSeconds(securityProperty.accessExp)
    )

}