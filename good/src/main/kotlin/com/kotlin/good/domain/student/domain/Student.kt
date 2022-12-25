package com.kotlin.good.domain.student.domain

import com.kotlin.good.domain.user.domain.User
import com.kotlin.good.global.enum.Major
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_student")
class Student(
    @Id
    val userId: UUID,

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)")
    val user: User,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(4)")
    val gcn: String,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(8)")
    val major: Major
)