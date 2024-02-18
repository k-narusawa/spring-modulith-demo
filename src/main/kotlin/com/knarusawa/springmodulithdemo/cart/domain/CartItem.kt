package com.knarusawa.springmodulithdemo.cart.domain

import com.knarusawa.springmodulithdemo.item.domain.ItemId

data class CartItem(
        val itemId: ItemId,
        var quantity: Int
)