package com.example.kotlin.domain.user.domain

import com.example.kotlin.global.entity.BaseIdEntity
import org.hibernate.validator.constraints.Length
import javax.persistence.Column
import javax.persistence.Entity
import javax.validation.constraints.NotNull

@Entity
class User(

        override val id: Long,

        @field:NotNull
        @Length(max = 20)
        @Column(unique = true)
        val email: String,

        password: String?,
        followingCounts: Int,
        followedCounts: Int
) : BaseIdEntity() {

    @Length(max = 60)
    var password: String? = password
        protected set

    var followingCounts: Int = followingCounts
        protected set

    var followedCounts: Int = followedCounts
        protected set

    fun addFollower() {
        this.followedCounts += 1
    }

    fun addFollowing() {
        this.followingCounts += 1
    }

}
