package com.knarusawa.springmodulithdemo.item.domain

interface ItemRepository {
    fun save(item: Item)
    fun findByItemId(itemId: ItemId): Item?
}