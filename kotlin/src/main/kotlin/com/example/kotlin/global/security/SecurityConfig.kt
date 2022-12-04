package com.example.kotlin.global.security

import com.example.kotlin.global.filter.FilterConfig
import com.example.kotlin.global.security.jwt.JwtTokenParser
import com.example.kotlin.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
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

    @Throws(Exception::class)
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().cors()
        http
                .authorizeRequests()

                .antMatchers("/**").permitAll()

                .anyRequest().permitAll()

                .and().apply(FilterConfig(jwtTokenParser, objectMapper))

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

}