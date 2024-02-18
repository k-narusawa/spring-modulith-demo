package com.knarusawa.springmodulithdemo.order.domain

import com.knarusawa.springmodulithdemo.item.domain.ItemId

data class OrderItem(
        val itemId: ItemId,
        val quantity: Int,
) {
}