package com.example.kotlincode.domain.user.persistence

import com.example.kotlincode.domain.user.persistence.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long> {

    fun existsByAccountId(accountId: String?): Boolean

    fun findByAccountId(accountId: String): UserEntity

}