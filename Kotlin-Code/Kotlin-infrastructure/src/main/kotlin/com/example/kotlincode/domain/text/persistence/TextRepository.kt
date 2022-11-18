package com.example.kotlincode.domain.text.persistence

import com.example.kotlincode.domain.text.persistence.entity.TextEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TextRepository : CrudRepository<TextEntity, Long> {
}