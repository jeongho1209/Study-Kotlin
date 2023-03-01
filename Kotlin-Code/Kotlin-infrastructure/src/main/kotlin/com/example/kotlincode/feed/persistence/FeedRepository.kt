package com.example.kotlincode.feed.persistence

import com.example.kotlincode.feed.persistence.entity.FeedEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FeedRepository : CrudRepository<FeedEntity, Long> {
}