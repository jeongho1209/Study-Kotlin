package com.kotlin.good.domain.delivery.domain

import com.kotlin.good.domain.order.domain.Order
import com.kotlin.good.global.entity.BaseUUIDEntity
import com.kotlin.good.global.enum.DeliveryStatus
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_delivery")
class Delivery(

    override val id: UUID,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(100)")
    val address: String,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    val deliveryStatus: DeliveryStatus,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    val order: Order

) : BaseUUIDEntity()