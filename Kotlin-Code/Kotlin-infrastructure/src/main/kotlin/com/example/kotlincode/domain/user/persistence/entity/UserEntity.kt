package com.example.kotlincode.domain.user.persistence.entity

import org.hibernate.validator.constraints.Length
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
class UserEntity(
        id: Long?,
        accountId: String,
        password: String,
        username: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id

    @field:NotNull
    @Column(unique = true)
    @Length(max = 20)
    var accountId: String = accountId
        protected set

    @field:NotNull
    @Length(max = 60)
    var password: String = password
        protected set

    @field:NotNull
    @Length(max = 8)
    var username: String = username
        protected set

}