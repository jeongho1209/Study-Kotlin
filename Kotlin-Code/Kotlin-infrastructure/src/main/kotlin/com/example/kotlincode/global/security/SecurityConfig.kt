package com.example.kotlincode.global.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

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
        http
                .authorizeRequests()

                // user
                .antMatchers("/user/signup").permitAll()

                .anyRequest().denyAll()

        return http.build()
    }

    @Bean
    protected fun passwordEncoder() = BCryptPasswordEncoder()

}