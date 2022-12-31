package com.kotlin.good.domain.user.domain.repository

import com.kotlin.good.domain.user.domain.User
import java.util.*

interface CustomUserRepository {

    fun queryUserListByMark(itemId: UUID): List<User>

}