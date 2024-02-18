package com.knarusawa.springmodulithdemo.item.application.query

import com.knarusawa.springmodulithdemo.item.application.dto.ItemDto

interface ItemDtoQueryService {
    fun findAll(): List<ItemDto>
}