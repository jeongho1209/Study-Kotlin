package com.example.kotlincode.domain

interface GenericMapper<E, D> {

    fun toDomain(entity: E): D
    fun toEntity(domain: D): E

}