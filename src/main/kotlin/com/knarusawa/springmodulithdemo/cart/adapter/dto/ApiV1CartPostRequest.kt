package com.knarusawa.springmodulithdemo.cart.adapter.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ApiV1CartPostRequest(
        @JsonProperty("item_id")
        val itemId: String,
        @JsonProperty("quantity")
        val quantity: Int
)