package com.example.kotlincode.user.mapper

import com.example.kotlincode.GenericMapper
import com.example.kotlincode.user.RefreshToken
import com.example.kotlincode.user.persistence.entity.RefreshTokenEntity
import org.mapstruct.Mapper

@Mapper
abstract class RefreshTokenMapper : GenericMapper<RefreshTokenEntity, RefreshToken> {
}