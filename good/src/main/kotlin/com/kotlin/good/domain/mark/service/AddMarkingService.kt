package com.kotlin.good.domain.mark.service

import com.kotlin.good.domain.item.facade.ItemFacade
import com.kotlin.good.domain.mark.domain.Mark
import com.kotlin.good.domain.mark.domain.MarkId
import com.kotlin.good.domain.mark.domain.repository.MarkRepository
import com.kotlin.good.domain.mark.error.exception.MarkExist
import com.kotlin.good.domain.mark.presentation.dto.response.AddMarkingResponse
import com.kotlin.good.global.security.SecurityFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class AddMarkingService(
    private val securityFacade: SecurityFacade,
    private val itemFacade: ItemFacade,
    private val markRepository: MarkRepository
) {

    @Transactional
    fun execute(itemId: UUID): AddMarkingResponse {
        val user = securityFacade.getCurrentUser()

        val item = itemFacade.getItemById(itemId)

        if (markRepository.existsByItemAndUser(item, user)) {
            throw MarkExist.EXCEPTINON
        }

        markRepository.save(
            Mark(
                markId = MarkId(
                    user = user.id,
                    item = item.id,
                ),
                user = user,
                item = item
            )
        )

        item.addMark()

        return AddMarkingResponse(
            isMarked = markRepository.existsByItemAndUser(item, user),
            markCount = item.markCount
        )
    }

}