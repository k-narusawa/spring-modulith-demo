package com.knarusawa.springmodulithdemo.item.application.dto

data class ItemDto(
        val itemId: String,
        val name: String,
        val description: String,
        val price: Int,
        val quantityInStock: Int
)