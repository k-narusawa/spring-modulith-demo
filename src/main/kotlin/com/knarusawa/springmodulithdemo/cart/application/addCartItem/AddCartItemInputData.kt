package com.knarusawa.springmodulithdemo.cart.application.addCartItem

import com.knarusawa.springmodulithdemo.auth.domain.UserId
import com.knarusawa.springmodulithdemo.item.domain.ItemId

data class AddCartItemInputData private constructor(
        val userId: UserId,
        val itemId: ItemId,
        val quantity: Int
) {
    companion object {
        fun of(userId: String, itemId: String, quantity: Int) = AddCartItemInputData(
                userId = UserId.from(userId),
                itemId = ItemId.from(itemId),
                quantity = quantity
        )
    }
}