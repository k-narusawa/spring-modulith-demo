package com.knarusawa.springmodulithdemo.cart.domain

import com.knarusawa.springmodulithdemo.auth.domain.UserId
import com.knarusawa.springmodulithdemo.cart.adapter.gateway.CartItemRecord
import com.knarusawa.springmodulithdemo.cart.adapter.gateway.CartRecord
import com.knarusawa.springmodulithdemo.item.domain.Item
import com.knarusawa.springmodulithdemo.item.domain.ItemId

class Cart private constructor(
        val cartId: CartId,
        val userId: UserId,
        items: List<CartItem>
) {
    var items = items
        private set

    companion object {
        fun of(userId: UserId) = Cart(
                cartId = CartId.of(),
                userId = userId,
                items = listOf()
        )

        fun from(cartRecord: CartRecord, cartItemRecords: List<CartItemRecord>): Cart {
            return Cart(
                    cartId = CartId.from(cartRecord.cartId),
                    userId = UserId.from(cartRecord.userId),
                    items = cartItemRecords.map {
                        CartItem(itemId = ItemId.from(it.itemId), quantity = it.quantity)
                    }
            )
        }
    }

    fun add(item: Item, quantity: Int = 1) {
        val existingItem = this.items.find { it.itemId.value() == item.itemId.value() }

        if (existingItem != null) {
            existingItem.quantity += quantity
        } else {
            val cartItem = CartItem(
                    itemId = item.itemId,
                    quantity = quantity,
            )
            this.items = this.items.plus(cartItem)
        }

    }

    fun remove(item: Item) {
        this.items = this.items.filterNot {
            it.itemId != item.itemId
        }
    }
}