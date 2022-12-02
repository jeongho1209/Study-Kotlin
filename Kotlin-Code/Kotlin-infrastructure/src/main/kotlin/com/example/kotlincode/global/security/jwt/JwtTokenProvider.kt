package com.example.kotlincode.global.security.jwt

import com.example.kotlincode.domain.user.dto.TokenResponse
import com.example.kotlincode.domain.user.persistence.RefreshTokenRepository
import com.example.kotlincode.domain.user.persistence.entity.RefreshTokenEntity
import com.example.kotlincode.domain.user.spi.UserJwtPort
import com.example.kotlincode.global.security.SecurityProperties
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenProvider(
        private val refreshTokenRepository: RefreshTokenRepository,
        private val securityProperties: SecurityProperties
) : UserJwtPort {

    private fun createAccessToken(accountId: String) =
            generateToken(accountId, JwtProperty.ACCESS_KEY, securityProperties.accessExp)

    private fun createRefreshToken(accountId: String): String {
        val token = generateToken(accountId, JwtProperty.REFRESH_KEY, securityProperties.refreshExp)

        refreshTokenRepository.save(
                RefreshTokenEntity(
                        token = token,
                        accountId = accountId,
                        expiredAt = securityProperties.refreshExp / 1000
                )
        )
        return token
    }

    private fun generateToken(accountId: String, type: String, expiredAt: Long) =
            Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, securityProperties.secretKey)
                    .claim("accountId", accountId)
                    .setHeaderParam(Header.JWT_TYPE, type)
                    .setIssuedAt(Date())
                    .setExpiration(Date(System.currentTimeMillis() + expiredAt))
                    .compact()

    override fun receiveToken(accountId: String) = TokenResponse(
            accessToken = createAccessToken(accountId),
            refreshToken = createRefreshToken(accountId),
            accessTokenExp = Date(System.currentTimeMillis() + securityProperties.accessExp)
    )

}