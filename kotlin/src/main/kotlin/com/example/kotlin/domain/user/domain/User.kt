package com.example.kotlin.domain.user.domain

import javax.persistence.*

@Entity
class User(
        id: Long?,
        accountId: String,
        password: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id

    @Column(length = 20, nullable = false)
    var accountId: String = accountId
        protected set

    @Column(length = 60, nullable = false)
    var password: String = password
        protected set
}
