package com.example.kotlincode.common.error

abstract class BusinessException(
    val errorProperty: ErrorProperty
) : RuntimeException() {

    override fun fillInStackTrace() = this

}