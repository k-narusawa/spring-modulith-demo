package com.knarusawa.springmodulithdemo.item.adapter.controller

import com.knarusawa.springmodulithdemo.item.adapter.dto.ApiV1ItemsGetResponse
import com.knarusawa.springmodulithdemo.item.application.query.ItemDtoQueryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/items")
class ItemController(
        private val cartDtoQueryService: ItemDtoQueryService
) {
    @GetMapping
    fun apiV1ItemsGet(): ApiV1ItemsGetResponse {
        val items = cartDtoQueryService.findAll()
        return ApiV1ItemsGetResponse(
                items = items.map {
                    ApiV1ItemsGetResponse.Item(
                            itemId = it.itemId,
                            name = it.name,
                            description = it.description,
                            price = it.price
                    )
                }
        )
    }
}