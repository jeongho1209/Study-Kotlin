package com.example.kotlin.domain.feed.domain

import com.example.kotlin.domain.feed.presentation.dto.response.FeedElement
import org.springframework.data.repository.CrudRepository

interface FeedRepository : CrudRepository<Feed, Long> {

    fun findAllByOrderByCreatedAtDesc(): List<Feed>

}