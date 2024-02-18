package com.knarusawa.springmodulithdemo.auth.domain


class User private constructor(
        val userId: UserId
) {
    companion object {
        fun from(userId: String) = User(
                userId = UserId.from(value = userId)
        )
    }
}