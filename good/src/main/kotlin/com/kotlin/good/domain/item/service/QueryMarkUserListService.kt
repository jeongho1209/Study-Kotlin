package com.kotlin.good.domain.item.service

import com.kotlin.good.domain.item.facade.ItemFacade
import com.kotlin.good.domain.user.domain.repository.UserRepository
import com.kotlin.good.domain.user.presentation.dto.response.QueryUserElement
import com.kotlin.good.domain.user.presentation.dto.response.QueryUserListResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class QueryMarkUserListService(
    val itemFacade: ItemFacade,
    val userRepository: UserRepository
) {

    @Transactional(readOnly = true)
    fun execute(itemId: UUID): QueryUserListResponse {
        val item = itemFacade.getItemById(itemId)

        val userList = userRepository.queryUserListByMark(item.id)

        return QueryUserListResponse(
            userList = userList

                .map {
                    QueryUserElement(
                        name = it.name,
                        address = it.address
                    )
                }
        )
    }

}