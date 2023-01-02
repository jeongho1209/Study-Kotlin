package com.kotlin.good.domain.user.domain.repository

import com.kotlin.good.domain.user.domain.User
import org.springframework.data.domain.Pageable
import java.util.*

interface CustomUserRepository {

    fun queryUserListByMark(itemId: UUID, pageable: Pageable): List<User>

}