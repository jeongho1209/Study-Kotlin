package com.example.kotlin.infrastructure.feign.config

import com.example.kotlin.infrastructure.feign.error.FeignClientErrorDecoder
import feign.codec.ErrorDecoder
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@EnableFeignClients(basePackages = ["com.example.kotlin.infrastructure.feign"])
@Import(FeignClientErrorDecoder::class)
@Configuration
class FeignConfig {

    @Bean
    @ConditionalOnMissingBean(value = [ErrorDecoder::class])
    fun feignErrorDecoder(): FeignClientErrorDecoder {
        return FeignClientErrorDecoder()
    }

}