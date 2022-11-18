package com.example.kotlincode.domain.user.mapper

import com.example.kotlincode.domain.GenericMapper
import com.example.kotlincode.domain.user.persistence.entity.UserEntity
import com.example.kotlincode.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserMapper : GenericMapper<UserEntity, User> {

    override fun toDomain(entity: UserEntity?): User? = entity?.let {
        User(
                id = it.id,
                accountId = it.accountId,
                password = it.password,
                username = it.username
        )
    }

    override fun toEntity(domain: User): UserEntity = UserEntity(
            id = domain.id,
            accountId = domain.accountId,
            password = domain.password,
            username = domain.username
    )

}