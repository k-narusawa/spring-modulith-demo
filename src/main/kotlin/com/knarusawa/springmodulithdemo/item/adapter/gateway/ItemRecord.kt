package com.knarusawa.springmodulithdemo.item.adapter.gateway

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "items")
data class ItemRecord(
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
