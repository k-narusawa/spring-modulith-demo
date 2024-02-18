package com.knarusawa.springmodulithdemo.cart.adapter.gateway

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "cart_items")
data class CartItemRecord(
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 0,

        @Column(name = "cart_id")
        val cartId: String = "",

        @Column(name = "item_id")
        val itemId: String = "",

        @Column(name = "quantity")
        val quantity: Int = 0,

        @Column(name = "created_at", insertable = false, updatable = false)
        val createdAt: LocalDateTime? = null,

        @Column(name = "updated_at", insertable = false, updatable = false)
        val updatedAt: LocalDateTime? = null
) {
}