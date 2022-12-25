package com.kotlin.good.domain.item.domain

import com.kotlin.good.global.entity.BaseUUIDEntity
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.DynamicInsert
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

@DynamicInsert
@Entity
@Table(name = "tbl_item")
class Item(
    override val id: UUID,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    val name: String,

    @field:NotNull
    @ColumnDefault("0")
    val stock: Int,

    @field:NotNull
    val price: Int,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(500)")
    val itemInfo: String
) : BaseUUIDEntity()