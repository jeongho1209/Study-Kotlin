package com.example.kotlincode.user.persistence

import com.example.kotlincode.user.User
import com.example.kotlincode.user.mapper.UserMapper
import com.example.kotlincode.user.spi.UserSpi
import com.example.kotlincode.common.annotation.Adapter

@Adapter
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : UserSpi {

    override fun save(user: User) {
        userRepository.save(userMapper.toEntity(user))
    }

    override fun existsUserByAccountId(accountId: String?): Boolean {
        return userRepository.existsByAccountId(accountId)
    }

    override fun getAccountId(accountId: String): User? = userMapper.toDomain(
        userRepository.findByAccountId(accountId)
    )

    override fun deleteUser(user: User) {
        userRepository.delete(userMapper.toEntity(user))
    }

}