package domain.user.domain

import annotation.Aggregate

@Aggregate
data class User(
        val id: Long?,

        val accountId: String,

        val password: String,

        val username: String

)
