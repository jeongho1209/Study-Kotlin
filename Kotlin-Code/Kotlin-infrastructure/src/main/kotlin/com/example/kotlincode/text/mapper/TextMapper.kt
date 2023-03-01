package com.example.kotlincode.text.mapper

import com.example.kotlincode.GenericMapper
import com.example.kotlincode.text.Text
import com.example.kotlincode.text.persistence.entity.TextEntity
import com.example.kotlincode.user.exception.UserNotFoundException
import com.example.kotlincode.user.persistence.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class TextMapper(
    private val userRepository: UserRepository
) : GenericMapper<TextEntity, Text> {

    override fun toDomain(entity: TextEntity): Text {
        return Text(
            id = entity.id,
            text = entity.text,
            user = entity.userEntity.id
        )
    }

    override fun toEntity(domain: Text): TextEntity {
        val user = userRepository.findByIdOrNull(domain.user)
            ?: throw UserNotFoundException
        return TextEntity(
            id = domain.id,
            text = domain.text,
            userEntity = user
        )
    }
}
