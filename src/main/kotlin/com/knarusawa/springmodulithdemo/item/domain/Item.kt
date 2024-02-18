package com.knarusawa.springmodulithdemo.item.domain

import com.knarusawa.springmodulithdemo.item.adapter.gateway.ItemRecord

class Item private constructor(
        val itemId: ItemId,
        name: String,
        description: String,
        price: Int,
        quantityInStock: Int
) {
    var name = name
        private set
    var description = description
        private set
    var price = price
        private set
    var quantityInStock = quantityInStock
        private set

    companion object {
        fun of(name: String, description: String, price: Int) = Item(
                itemId = ItemId.of(),
                name = name,
                description = description,
                price = price,
                quantityInStock = 0
        )

        fun from(record: ItemRecord) = Item(
                itemId = ItemId.from(record.itemId),
                name = record.name,
                description = record.description,
                price = record.price,
                quantityInStock = record.quantityInStock,
        )
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Item) {
            this.itemId.value() == other.itemId.value()
        } else {
            false
        }
    }
}