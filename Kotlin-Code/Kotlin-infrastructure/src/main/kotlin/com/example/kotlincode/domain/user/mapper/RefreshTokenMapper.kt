package com.example.kotlincode.domain.user.mapper

import com.example.kotlincode.domain.GenericMapper
import com.example.kotlincode.domain.user.domain.RefreshToken
import com.example.kotlincode.domain.user.persistence.entity.RefreshTokenEntity
import org.mapstruct.Mapper

@Mapper
abstract class RefreshTokenMapper : GenericMapper<RefreshTokenEntity, RefreshToken> {
}