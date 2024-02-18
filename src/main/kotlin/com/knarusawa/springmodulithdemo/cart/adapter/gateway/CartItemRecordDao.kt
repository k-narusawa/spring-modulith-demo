package com.knarusawa.springmodulithdemo.cart.adapter.gateway

import org.springframework.data.repository.CrudRepository

interface CartItemRecordDao : CrudRepository<CartItemRecord, Int> {
    fun findByCartId(cartId: String): List<CartItemRecord>
    fun deleteByCartId(cartId: String)
}