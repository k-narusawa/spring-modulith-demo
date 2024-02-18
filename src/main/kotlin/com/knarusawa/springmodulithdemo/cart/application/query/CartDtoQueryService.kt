package com.knarusawa.springmodulithdemo.cart.application.query

import com.knarusawa.springmodulithdemo.cart.application.dto.CartDto

interface CartDtoQueryService {
    fun findByUserId(userId: String): CartDto?
}