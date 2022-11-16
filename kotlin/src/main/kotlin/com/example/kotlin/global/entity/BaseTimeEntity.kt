package com.example.kotlin.global.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseTimeEntity(

        @Column(nullable = false)
        open val createdAt: LocalDateTime = LocalDateTime.now()

)