package com.knarusawa.springmodulithdemo.order.adapter.gateway

import jakarta.persistence.Column
import jakarta.persistence.Id
import java.time.LocalDateTime

data class OrderRecord(
        @Id
        @Column(name = "item_id")
        val itemId: String = "",

        @Column(name = "name")
        val name: String = "",

        @Column(name = "description")
        val description: String = "",

        @Column(name = "price")
        val price: Int = 0,

        @Column(name = "quantity_in_stock")
        val quantityInStock: Int = 0,

        @Column(name = "created_at", insertable = false, updatable = false)
        val createdAt: LocalDateTime? = null,

        @Column(name = "updated_at", insertable = false, updatable = false)
        val updatedAt: LocalDateTime? = null
)
