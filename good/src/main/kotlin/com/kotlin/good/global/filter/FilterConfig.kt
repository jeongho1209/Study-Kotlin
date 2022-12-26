package com.kotlin.good.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlin.good.global.security.jwt.JwtTokenParser
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val jwtTokenParser: JwtTokenParser,
    private val objectMapper: ObjectMapper
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(
            JwtTokenFilter(jwtTokenParser),
            UsernamePasswordAuthenticationFilter::class.java
        )
        builder.addFilterBefore(
            ExceptionFilter(objectMapper), JwtTokenFilter::class.java
        )
    }

}