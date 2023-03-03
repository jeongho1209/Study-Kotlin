package com.example.kotlincode.user.persistence

import com.example.kotlincode.user.persistence.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
}