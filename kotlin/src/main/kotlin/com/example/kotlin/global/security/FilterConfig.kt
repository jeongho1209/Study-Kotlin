package com.example.kotlin.global.security

import com.example.kotlin.global.filter.ExceptionFilter
import com.example.kotlin.global.security.jwt.JwtTokenFilter
import com.example.kotlin.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
        private val jwtTokenProvider: JwtTokenProvider,
        private val objectMapper: ObjectMapper
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(
                JwtTokenFilter(jwtTokenProvider),
                UsernamePasswordAuthenticationFilter::class.java
        )
        builder.addFilterBefore(
                ExceptionFilter(objectMapper), JwtTokenFilter::class.java
        )
    }

}