package com.knarusawa.springmodulithdemo.cart.application.addCartItem

import com.knarusawa.springmodulithdemo.cart.domain.Cart
import com.knarusawa.springmodulithdemo.cart.domain.CartRepository
import com.knarusawa.springmodulithdemo.item.domain.ItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AddCartItemService(
        private val cartRepository: CartRepository,
        private val itemRepository: ItemRepository
) {
    @Transactional
    fun exec(inputData: AddCartItemInputData) {
        val cart = cartRepository.findByUserId(userId = inputData.userId)
                ?: Cart.of(inputData.userId)
        val item = itemRepository.findByItemId(itemId = inputData.itemId)
                ?: throw IllegalStateException("itemが存在しません")

        if (item.quantityInStock < inputData.quantity) {
            throw IllegalStateException("在庫が不足しています")
        }

        cart.add(item = item, quantity = inputData.quantity)
        cartRepository.save(cart)
    }
}