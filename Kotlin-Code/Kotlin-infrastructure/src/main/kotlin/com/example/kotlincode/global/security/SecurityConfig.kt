package com.example.kotlincode.global.security

import com.example.kotlincode.global.filter.FilterConfig
import com.example.kotlincode.global.security.jwt.JwtTokenParser
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
        private val objectMapper: ObjectMapper,
        private val jwtTokenParser: JwtTokenParser
) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
                .csrf().disable()
                .formLogin().disable()
                .cors()
                .and()
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)


        http.apply(FilterConfig(objectMapper, jwtTokenParser))

        http
                .authorizeRequests()

                // user
                .antMatchers("/user/signup").permitAll()
                .antMatchers("/user/login").permitAll()
                .anyRequest().denyAll()

        return http.build()
    }

    @Bean
    protected fun passwordEncoder() = BCryptPasswordEncoder()

}