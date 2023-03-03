package com.example.kotlincode.user.mapper

import com.example.kotlincode.GenericMapper
import com.example.kotlincode.user.User
import com.example.kotlincode.user.persistence.entity.UserEntity
import org.springframework.stereotype.Component

@Component
class UserMapper : GenericMapper<UserEntity, User> {

    override fun toDomain(entity: UserEntity): User = entity.let {
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