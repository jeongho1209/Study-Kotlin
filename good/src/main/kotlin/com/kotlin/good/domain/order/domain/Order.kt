package com.kotlin.good.domain.order.domain

import com.kotlin.good.domain.order.error.exception.AlreadyCancelOrder
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    val orderItems: List<OrderItem> = ArrayList(),

    orderStatus: OrderStatus
) : BaseUUIDEntity() {

    @field:NotNull
    @Enumerated(EnumType.STRING)
    var orderStatus = orderStatus
        protected set

    fun cancelOrder() {
        if (orderStatus == OrderStatus.CANCEL) {
            throw AlreadyCancelOrder.EXCEPTION
        }
        this.orderStatus = OrderStatus.CANCEL
    }

}