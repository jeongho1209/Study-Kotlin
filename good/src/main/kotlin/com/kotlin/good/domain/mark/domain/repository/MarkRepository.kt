package com.kotlin.good.domain.mark.domain.repository

import com.kotlin.good.domain.mark.domain.Mark
import com.kotlin.good.domain.mark.domain.MarkId
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MarkRepository : CrudRepository<Mark, MarkId> {
}