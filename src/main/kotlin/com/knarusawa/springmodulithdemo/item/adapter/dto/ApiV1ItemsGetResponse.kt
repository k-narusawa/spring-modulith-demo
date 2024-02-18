package com.knarusawa.springmodulithdemo.item.adapter.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ApiV1ItemsGetResponse(
        @JsonProperty("items")
        val items: List<Item>
) {
    data class Item(
            @JsonProperty("item_id")
            val itemId: String,

            @JsonProperty("name")
            val name: String,

            @JsonProperty("description")
            val description: String,

            @JsonProperty("price")
            val price: Int,
    )
}