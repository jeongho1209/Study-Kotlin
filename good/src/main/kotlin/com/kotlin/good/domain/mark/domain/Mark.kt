package com.kotlin.good.domain.mark.domain

import com.kotlin.good.domain.item.domain.Item
import com.kotlin.good.domain.user.domain.User
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_mark")
class Mark(
    @EmbeddedId
    val markId: MarkId,

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @MapsId("itemId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    val item: Item
)