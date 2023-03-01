package com.example.kotlincode.text.persistence

import com.example.kotlincode.text.persistence.entity.TextEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TextRepository : CrudRepository<TextEntity, Long> {
}