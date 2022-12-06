package com.example.kotlin.domain.feed.domain.repository

import com.example.kotlin.domain.feed.domain.Feed

interface CustomFeedRepository {

    fun queryFeedList(): List<Feed>

}