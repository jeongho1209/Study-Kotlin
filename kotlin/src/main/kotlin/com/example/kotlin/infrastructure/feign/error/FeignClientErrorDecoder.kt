package com.example.kotlin.infrastructure.feign.error

import com.example.kotlin.infrastructure.feign.exception.FeignBadRequestException
import com.example.kotlin.infrastructure.feign.exception.FeignExpiredTokenException
import com.example.kotlin.infrastructure.feign.exception.FeignForbiddenException
import com.example.kotlin.infrastructure.feign.exception.FeignUnAuthorizedException
import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder

class FeignClientErrorDecoder : ErrorDecoder {

    override fun decode(methodKey: String, response: Response): Exception {
        if (response.status() >= 400) {
            val a = response.request()
            println(a)
            when (response.status()) {
                401 -> throw FeignUnAuthorizedException.EXCEPTION
                403 -> throw FeignForbiddenException.EXCEPTION
                419 -> throw FeignExpiredTokenException.EXCEPTION
                else -> throw FeignBadRequestException.EXCEPTION
            }
        }

        return FeignException.errorStatus(methodKey, response)
    }

}