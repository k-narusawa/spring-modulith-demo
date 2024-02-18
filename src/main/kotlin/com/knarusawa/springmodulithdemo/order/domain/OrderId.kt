package com.knarusawa.springmodulithdemo.order.domain

import java.util.*

class OrderId private constructor(
        private val value: UUID
) {
    companion object {
        fun of() = OrderId(value = UUID.randomUUID())
        fun from(value: String): OrderId {
            // 失敗したらIllegalArgumentExceptionが投げられる
            return OrderId(UUID.fromString(value))
        }
    }

    fun value() = this.value.toString()

    override fun toString(): String {
        return this.value()
    }
}