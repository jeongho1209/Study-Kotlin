package com.example.kotlin.domain.feed.domain.repository

import com.example.kotlin.domain.feed.domain.Feed
import com.example.kotlin.domain.feed.domain.QFeed.feed
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomFeedRepositoryImpl(
        private val jpaQueryFactory: JPAQueryFactory
) : CustomFeedRepository {

    override fun queryFeedList(): List<Feed> {
        return jpaQueryFactory
                .selectFrom(feed)
                .fetch()
    }

}