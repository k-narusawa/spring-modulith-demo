package com.knarusawa.springmodulithdemo.cart.adapter.gateway

import org.springframework.data.repository.CrudRepository

interface CartRecordDao : CrudRepository<CartRecord, String> {
    fun findByUserId(userId: String): CartRecord?
}