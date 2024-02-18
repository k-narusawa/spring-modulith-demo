package com.knarusawa.springmodulithdemo.cart.domain

import java.util.*

data class CartId private constructor(
        private val value: UUID
) {
    companion object {
        fun of() = CartId(value = UUID.randomUUID())
        fun from(value: String): CartId {
            // 失敗したらIllegalArgumentExceptionが投げられる
            return CartId(UUID.fromString(value))
        }
    }

    fun value() = this.value.toString()

    override fun toString(): String {
        return this.value()
    }
}