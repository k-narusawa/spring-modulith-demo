package com.knarusawa.springmodulithdemo.cart.adapter.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.knarusawa.springmodulithdemo.cart.domain.Cart

data class ApiV1CartGetResponse(
        @JsonProperty("cart")
        val cart: Cart?
) {
    data class Cart(
            @JsonProperty("cart_id")
            val cartId: String,
            @JsonProperty("user_id")
            val userId: String,
            @JsonProperty("items")
            val items: List<Item>
    ) {
        data class Item(
                @JsonProperty("item_id")
                val itemId: String,
                @JsonProperty("quantity")
                val quantity: Int
        )
    }
}
