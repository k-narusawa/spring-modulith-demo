package com.knarusawa.springmodulithdemo.item.adapter.gateway

import com.knarusawa.springmodulithdemo.item.domain.Item
import com.knarusawa.springmodulithdemo.item.domain.ItemId
import com.knarusawa.springmodulithdemo.item.domain.ItemRepository
import org.springframework.stereotype.Repository

@Repository
class ItemRepositoryImpl(
        private val itemRecordDao: ItemRecordDao
) : ItemRepository {
    override fun save(item: Item) {
        val record = ItemRecord(
                itemId = item.itemId.value(),
                name = item.name,
                description = item.description,
                price = item.price,
                quantityInStock = item.quantityInStock,
        )

        itemRecordDao.save(record)
    }

    override fun findByItemId(itemId: ItemId): Item? {
        val record = itemRecordDao.findByItemId(itemId = itemId.value())
        return record?.let { Item.from(record) }
    }
}