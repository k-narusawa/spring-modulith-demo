package com.knarusawa.springmodulithdemo.cart.adapter.gateway

import com.knarusawa.springmodulithdemo.auth.domain.UserId
import com.knarusawa.springmodulithdemo.cart.domain.Cart
import com.knarusawa.springmodulithdemo.cart.domain.CartRepository
import org.springframework.stereotype.Repository

@Repository
class CartRepositoryImpl(
        private val cartRecordDao: CartRecordDao,
        private val cartItemRecordDao: CartItemRecordDao
) : CartRepository {
    override fun save(cart: Cart) {
        val cartRecord = CartRecord(
                cartId = cart.cartId.value(),
                userId = cart.userId.value(),
        )

        cartRecordDao.save(cartRecord)

        // delete,insertで処理する
        cartItemRecordDao.deleteByCartId(cartId = cart.cartId.value())
        cart.items.forEach { item ->
            val itemRecord = CartItemRecord(
                    cartId = cart.cartId.value(),
                    itemId = item.itemId.value(),
                    quantity = item.quantity,
            )
            cartItemRecordDao.save(itemRecord)
        }
    }

    override fun findByUserId(userId: UserId): Cart? {
        val cartRecord = cartRecordDao.findByUserId(userId = userId.value()) ?: return null
        val cartItemsRecord = cartItemRecordDao.findByCartId(cartId = cartRecord.cartId)

        return Cart.from(cartRecord, cartItemsRecord)
    }
}