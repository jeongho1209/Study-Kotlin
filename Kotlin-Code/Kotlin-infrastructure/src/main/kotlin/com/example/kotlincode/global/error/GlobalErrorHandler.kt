package com.example.kotlincode.global.error

import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalErrorHandler {

    @ExceptionHandler(BindException::class)
    protected fun handleBindException(e: BindException): BindErrorResponse? = ErrorResponse.of(e)

}