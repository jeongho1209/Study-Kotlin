package com.kotlin.good.domain.mark.domain

import com.kotlin.good.domain.item.domain.Item
import com.kotlin.good.domain.user.domain.User
import org.springframework.data.domain.Persistable
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tbl_mark")
class Mark(

    @EmbeddedId
    val markId: MarkId,

    @MapsId("user")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user: User,

    @MapsId("item")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", columnDefinition = "BINARY(16)", nullable = false)
    val item: Item

) : Serializable