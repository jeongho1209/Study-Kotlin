package com.kotlin.good.domain.user.domain.repository

import com.kotlin.good.domain.mark.domain.QMark.mark
import com.kotlin.good.domain.user.domain.QUser.user
import com.kotlin.good.domain.user.domain.User
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Pageable
import java.util.*

class CustomUserRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : CustomUserRepository {

    override fun queryUserListByMark(itemId: UUID, pageable: Pageable): List<User> {
        return queryFactory
            .selectFrom(user)
            .distinct()
            .innerJoin(mark)
            .on(mark.item.id.eq(itemId))
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()
    }

}