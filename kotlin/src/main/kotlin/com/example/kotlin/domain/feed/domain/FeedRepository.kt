package com.example.kotlin.domain.feed.domain

import org.springframework.data.repository.CrudRepository

interface FeedRepository : CrudRepository<Feed, Long> {


}