package com.knarusawa.springmodulithdemo.cart.adapter.gateway

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "carts")
data class CartRecord(
        @Id
        @Column(name = "cart_id")
        val cartId: String = "",

        @Column(name = "user_id")
        val userId: String = "",

        @Column(name = "created_at", insertable = false, updatable = false)
        val createdAt: LocalDateTime? = null,

        @Column(name = "updated_at", insertable = false, updatable = false)
        val updatedAt: LocalDateTime? = null
)
