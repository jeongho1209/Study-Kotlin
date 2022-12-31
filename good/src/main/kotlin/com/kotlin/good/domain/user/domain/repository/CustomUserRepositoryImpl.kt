package com.kotlin.good.domain.user.domain.repository

import com.kotlin.good.domain.mark.domain.QMark.mark
import com.kotlin.good.domain.user.domain.QUser.user
import com.kotlin.good.domain.user.domain.User
import com.querydsl.jpa.impl.JPAQueryFactory
import java.util.*

class CustomUserRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : CustomUserRepository {

    override fun queryUserListByMark(itemId: UUID): List<User> {
        return queryFactory
            .selectFrom(user)
            .innerJoin(mark)
            .on(mark.item.id.eq(itemId))
            .distinct()
            .fetch()
    }

}