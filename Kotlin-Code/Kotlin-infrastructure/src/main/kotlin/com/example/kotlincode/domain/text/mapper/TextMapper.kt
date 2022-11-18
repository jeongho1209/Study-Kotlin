package com.example.kotlincode.domain.text.mapper

import com.example.kotlincode.domain.GenericMapper
import com.example.kotlincode.domain.text.domain.Text
import com.example.kotlincode.domain.text.persistence.entity.TextEntity
import com.example.kotlincode.domain.user.persistence.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class TextMapper(
        private val userRepository: UserRepository
) : GenericMapper<TextEntity, Text> {

    override fun toDomain(entity: TextEntity): Text = entity.let {
        Text(
                id = it.id,
                text = it.text,
                user = it.userEntity.id
        )
    }

    override fun toEntity(domain: Text): TextEntity {
        val user = userRepository.findByIdOrNull(domain.user)!!
        return TextEntity(
                id = domain.id,
                text = domain.text,
                userEntity = user
        )
    }

}