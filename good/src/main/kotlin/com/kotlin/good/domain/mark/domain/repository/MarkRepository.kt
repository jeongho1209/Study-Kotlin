package com.kotlin.good.domain.mark.domain.repository

import com.kotlin.good.domain.item.domain.Item
import com.kotlin.good.domain.mark.domain.Mark
import com.kotlin.good.domain.mark.domain.MarkId
import com.kotlin.good.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MarkRepository : CrudRepository<Mark, MarkId> {

    fun existsByItemAndUser(item: Item, user: User): Boolean

}