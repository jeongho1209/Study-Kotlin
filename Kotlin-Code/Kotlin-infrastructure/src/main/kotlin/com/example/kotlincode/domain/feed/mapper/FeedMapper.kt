package com.example.kotlincode.domain.feed.mapper

import com.example.kotlincode.domain.GenericMapper
import com.example.kotlincode.domain.feed.domain.Feed
import com.example.kotlincode.domain.feed.persistence.entity.FeedEntity
import com.example.kotlincode.domain.user.persistence.entity.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class FeedMapper(
        private val userRepository: UserRepository
) : GenericMapper<FeedEntity, Feed> {

    override fun toDomain(entity: FeedEntity): Feed = entity.let {
        Feed(
                id = it.id,
                title = it.title,
                content = it.content,
                isCompleted = it.isCompleted,
                createdAt = it.createdAt,
                userId = it.userEntity.id
        )
    }

    override fun toEntity(domain: Feed): FeedEntity {
        val userEntity = userRepository.findByIdOrNull(domain.userId)!!

        return FeedEntity(
                id = domain.id,
                title = domain.title,
                content = domain.content,
                createdAt = domain.createdAt,
                isCompleted = domain.isCompleted,
                userEntity = userEntity
        )
    }

}