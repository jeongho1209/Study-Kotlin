package com.kotlin.good.domain.refresh_token.domain.repository

import com.kotlin.good.domain.refresh_token.domain.RefreshToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : CrudRepository<RefreshToken, String> {
}