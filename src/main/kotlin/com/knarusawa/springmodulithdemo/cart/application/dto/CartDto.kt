package com.knarusawa.springmodulithdemo.cart.application.dto

data class CartDto(
        val cartId: String,
        val userId: String,
        val items: List<Item>
) {
    data class Item(
            val itemId: String,
            val quantity: Int
    )
}