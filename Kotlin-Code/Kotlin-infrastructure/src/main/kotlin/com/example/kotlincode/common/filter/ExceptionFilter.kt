package com.example.kotlincode.common.filter

import com.example.kotlincode.common.error.BusinessException
import com.example.kotlincode.common.error.ErrorProperty
import com.example.kotlincode.common.error.ErrorResponse
import com.example.kotlincode.common.error.GlobalErrorCode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter(
        private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: BusinessException) {
            setError(e.errorProperty, response)
        } catch (e: Exception) {
            when (e.cause) {
                is BusinessException -> setError((e.cause as BusinessException).errorProperty, response)
                else -> {
                    setError(GlobalErrorCode.INTERNAL_SERVER_ERROR, response)
                }
            }
        }
    }

    private fun setError(errorProperty: ErrorProperty, response: HttpServletResponse) {
        response.status = errorProperty.status()
        response.characterEncoding = "UTF-8"
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(ErrorResponse.of(errorProperty)))
    }

}