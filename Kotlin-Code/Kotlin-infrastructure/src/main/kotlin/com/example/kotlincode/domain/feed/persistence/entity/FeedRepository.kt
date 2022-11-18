package com.example.kotlincode.domain.feed.persistence.entity

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FeedRepository : CrudRepository<FeedEntity, Long> {
}