package com.kotlin.good.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlin.good.global.filter.FilterConfig
import com.kotlin.good.global.security.jwt.JwtTokenParser
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenParser: JwtTokenParser,
    private val objectMapper: ObjectMapper
) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .formLogin().disable()
            .cors()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http
            .authorizeRequests()

            .anyRequest().authenticated()

            .and().apply(FilterConfig(jwtTokenParser, objectMapper))

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

}