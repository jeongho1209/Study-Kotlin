package com.kotlin.good.domain.order.domain

import com.kotlin.good.domain.item.domain.Item
import com.kotlin.good.global.entity.BaseUUIDEntity
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_order_item")
class OrderItem(
    override val id: UUID,

    @field:NotNull
    val count: Int,

    @field:NotNull
    val price: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    val order: Order,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    val item: Item
) : BaseUUIDEntity()