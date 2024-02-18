package com.knarusawa.springmodulithdemo.item.adapter.gateway

import org.springframework.data.repository.CrudRepository

interface ItemRecordDao : CrudRepository<ItemRecord, String> {
    fun findByItemId(itemId: String): ItemRecord?
}