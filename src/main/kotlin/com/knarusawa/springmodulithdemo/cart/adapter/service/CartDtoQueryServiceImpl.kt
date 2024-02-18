package com.knarusawa.springmodulithdemo.cart.adapter.service

import com.knarusawa.springmodulithdemo.cart.adapter.gateway.CartItemRecordDao
import com.knarusawa.springmodulithdemo.cart.adapter.gateway.CartRecordDao
import com.knarusawa.springmodulithdemo.cart.application.dto.CartDto
import com.knarusawa.springmodulithdemo.cart.application.query.CartDtoQueryService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CartDtoQueryServiceImpl(
        private val cartRecordDao: CartRecordDao,
        private val cartItemRecordDao: CartItemRecordDao,
) : CartDtoQueryService {
    override fun findByUserId(userId: String): CartDto? {
        val cartRecord = cartRecordDao.findByUserId(userId = userId) ?: return null
        val cartItemsRecord = cartItemRecordDao.findByCartId(cartId = cartRecord.cartId)

        return CartDto(
                cartId = cartRecord.cartId,
                userId = cartRecord.userId,
                items = cartItemsRecord.map {
                    CartDto.Item(
                            itemId = it.itemId,
                            quantity = it.quantity
                    )
                })
    }
}