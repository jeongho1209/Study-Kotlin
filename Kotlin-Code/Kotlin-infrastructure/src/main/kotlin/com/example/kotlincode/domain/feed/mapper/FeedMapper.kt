package com.example.kotlincode.domain.feed.mapper

import com.example.kotlincode.domain.GenericMapper
import com.example.kotlincode.domain.feed.domain.Feed
import com.example.kotlincode.domain.feed.persistence.entity.FeedEntity
import com.example.kotlincode.domain.user.exception.UserNotFoundException
import com.example.kotlincode.domain.user.persistence.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class FeedMapper(
    private val userRepository: UserRepository
) : GenericMapper<FeedEntity, Feed> {

    override fun toDomain(entity: FeedEntity): Feed = entity.run {
        Feed(
            id = id,
            title = title,
            content = content,
            isCompleted = isCompleted,
            createdAt = createdAt,
            userId = userEntity.id
        )
    }

    override fun toEntity(domain: Feed): FeedEntity {
        val userEntity = userRepository.findByIdOrNull(domain.userId)
            ?: throw UserNotFoundException

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