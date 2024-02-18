package com.knarusawa.springmodulithdemo.item.domain

import java.util.*

class ItemId private constructor(
        private val value: UUID
) {
    companion object {
        fun of() = ItemId(value = UUID.randomUUID())
        fun from(value: String): ItemId {
            // 失敗したらIllegalArgumentExceptionが投げられる
            return ItemId(UUID.fromString(value))
        }
    }

    fun value() = this.value.toString()

    override fun toString(): String {
        return this.value()
    }
}