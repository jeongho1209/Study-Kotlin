package com.example.kotlin.global.security.jwt

import com.example.kotlin.domain.user.presentation.dto.response.TokenResponse
import com.example.kotlin.global.exception.ExpiredTokenException
import com.example.kotlin.global.exception.InvalidTokenException
import com.example.kotlin.global.exception.UnExpectedTokenException
import com.example.kotlin.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
        private val jwtProperties: JwtProperties,
        private val authDetailsService: AuthDetailsService
) {

    fun getToken(accountId: String): TokenResponse {
        val accessToken: String = generateToken(accountId, jwtProperties.accessExp, JwtProperties.ACCESS_KEY)
        return TokenResponse(accessToken)
    }

    private fun generateToken(accountId: String, exp: Long, type: String): String {
        return JwtProperties.PREFIX + Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
                .setSubject(accountId)
                .setHeaderParam("type", type)
                .setIssuedAt(Date())
                .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
                .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? = request.getHeader(JwtProperties.HEADER)

    fun parseToken(token: String): String {
        if (!token.startsWith(JwtProperties.PREFIX)) {
            throw InvalidTokenException.EXCEPTION
        }

        return token.replace(JwtProperties.PREFIX, "")
    }

    fun authentication(token: String): Authentication {
        val subject = getClaimsBody(token).subject
        val authDetails = authDetailsService.loadUserByUsername(subject)
        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }

    private fun getClaimsBody(token: String): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperties.secretKey)
                    .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw ExpiredTokenException.EXCEPTION
                else -> throw UnExpectedTokenException.EXCEPTION
            }
        }
    }

}