package com.knarusawa.springmodulithdemo.cart.domain

import com.knarusawa.springmodulithdemo.auth.domain.UserId

interface CartRepository {
    fun save(cart: Cart)
    fun findByUserId(userId: UserId): Cart?
}