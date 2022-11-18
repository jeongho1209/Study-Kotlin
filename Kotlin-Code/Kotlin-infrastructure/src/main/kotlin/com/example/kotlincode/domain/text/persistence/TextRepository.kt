package com.example.kotlincode.domain.text.persistence

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TextRepository : CrudRepository<TextEntity, Long> {
}