package com.example.kotlin.global.security.jwt

import com.example.kotlin.global.exception.ExpiredTokenException
import com.example.kotlin.global.exception.InternalServerErrorException
import com.example.kotlin.global.exception.InvalidTokenException
import com.example.kotlin.global.security.SecurityProperties
import com.example.kotlin.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtTokenParser(
    private val securityProperties: SecurityProperties,
    private val authDetailsService: AuthDetailsService
) {

    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(securityProperties.secretKey)
                .parseClaimsJws(token).body
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
        val id = claims.subject
        val authDetails = authDetailsService.loadUserByUsername(id.toString())

        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }

}