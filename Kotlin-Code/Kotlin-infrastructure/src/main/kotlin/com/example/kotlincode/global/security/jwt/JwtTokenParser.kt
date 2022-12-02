package com.example.kotlincode.global.security.jwt

import com.example.kotlincode.global.exception.ExpiredTokenException
import com.example.kotlincode.global.exception.InternalServerErrorException
import com.example.kotlincode.global.exception.InvalidTokenException
import com.example.kotlincode.global.security.SecurityProperties
import com.example.kotlincode.global.security.auth.AuthDetailsService
import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtTokenParser(
        private val securityProperties: SecurityProperties,
        private val authDetailsService: AuthDetailsService
) {

    private fun getClaims(token: String): Jws<Claims> {
        return try {
            Jwts.parser()
                    .setSigningKey(securityProperties.secretKey)
                    .parseClaimsJws(token)
        } catch (e: Exception) {
            when (e) {
                is InvalidClaimException -> throw InvalidTokenException.EXCEPTION
                is ExpiredJwtException -> throw ExpiredTokenException.EXCEPTION
                else -> throw InternalServerErrorException.EXCEPTION
            }
        }
    }

    fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token)

        val details = authDetailsService.loadUserByUsername(claims.body.id)

        return UsernamePasswordAuthenticationToken(details, "", details.authorities)
    }

}