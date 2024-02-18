package com.knarusawa.springmodulithdemo.item.adapter.service

import com.knarusawa.springmodulithdemo.item.adapter.gateway.ItemRecordDao
import com.knarusawa.springmodulithdemo.item.application.dto.ItemDto
import com.knarusawa.springmodulithdemo.item.application.query.ItemDtoQueryService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ItemDtoQueryServiceImpl(
        private val itemRecordDao: ItemRecordDao
) : ItemDtoQueryService {
    override fun findAll(): List<ItemDto> {
        return itemRecordDao.findAll().map { record ->
            ItemDto(
                    itemId = record.itemId,
                    name = record.name,
                    description = record.description,
                    price = record.price,
                    quantityInStock = record.quantityInStock
            )
        }
    }
}