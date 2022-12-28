package com.kotlin.good.domain.item.domain

import com.kotlin.good.domain.item.error.exception.ItemNotFound
import com.kotlin.good.global.entity.BaseUUIDEntity
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_item")
class Item(
    override val id: UUID,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    val name: String,

    @field:NotNull
    val price: Int,

    itemInfo: String,

    stock: Int
) : BaseUUIDEntity() {

    @field:NotNull
    @field:Min(0)
    var stock = stock
        protected set

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(500)")
    var itemInfo = itemInfo
        protected set

    fun minusStock(count: Int) {
        if (this.stock <= 0) {
            throw ItemNotFound.EXCEPTION
        }
        this.stock -= count
    }

    fun plusStock(count: Int) {
        this.stock += count
    }

}