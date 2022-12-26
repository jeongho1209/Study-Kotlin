package com.kotlin.good.domain.order.domain

import com.kotlin.good.domain.user.domain.User
import com.kotlin.good.global.entity.BaseUUIDEntity
import com.kotlin.good.global.enum.OrderStatus
import java.time.LocalDate
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_order")
class Order(

    override val id: UUID,

    @field:NotNull
    val orderDate: LocalDate,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    val orderStatus: OrderStatus,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User

) : BaseUUIDEntity()