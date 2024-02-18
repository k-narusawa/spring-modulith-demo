package com.knarusawa.springmodulithdemo.order.domain

import com.knarusawa.springmodulithdemo.auth.domain.UserId
import java.time.LocalDateTime

class Order private constructor(
        val orderId: OrderId,
        val userId: UserId,
        val orderItems: List<OrderItem>,
        val orderDate: LocalDateTime,
) {
    companion object {
        fun of(userId: UserId, orderItems: List<OrderItem>) = Order(
                orderId = OrderId.of(),
                userId = userId,
                orderItems = orderItems,
                orderDate = LocalDateTime.now(),
        )
    }
}