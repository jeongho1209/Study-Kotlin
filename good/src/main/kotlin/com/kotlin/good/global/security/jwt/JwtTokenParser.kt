package com.kotlin.good.global.security.jwt

import com.kotlin.good.global.exception.ExpiredToken
import com.kotlin.good.global.exception.InternalServerError
import com.kotlin.good.global.exception.InvalidToken
import com.kotlin.good.global.security.SecurityProperty
import com.kotlin.good.global.security.auth.AuthDetailsService
import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtTokenParser(
    private val securityProperty: SecurityProperty,
    private val authDetailsService: AuthDetailsService
) {

    private fun getClaims(token: String): Jws<Claims> {
        return try {
            Jwts.parser()
                .setSigningKey(securityProperty.secretKey)
                .parseClaimsJws(token)
        } catch (e: Exception) {
            when (e) {
                is InvalidClaimException -> throw InvalidToken.EXCEPTION
                is ExpiredJwtException -> throw ExpiredToken.EXCEPTION
                else -> throw InternalServerError.EXCEPTION
            }
        }
    }

    fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token)

        val details = authDetailsService.loadUserByUsername(claims.body.id)

        return UsernamePasswordAuthenticationToken(details, "", details.authorities)
    }

}