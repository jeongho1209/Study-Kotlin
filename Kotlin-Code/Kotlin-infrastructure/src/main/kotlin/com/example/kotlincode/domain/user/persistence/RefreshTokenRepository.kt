package com.example.kotlincode.domain.user.persistence

import com.example.kotlincode.domain.user.persistence.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
}