package com.example.kotlincode.error

abstract class BusinessException(
    val errorProperty: ErrorProperty
) : RuntimeException() {

    override fun fillInStackTrace() = this

}