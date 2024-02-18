package com.knarusawa.springmodulithdemo.order.domain

interface OrderRepository {
    fun save(order: Order)
}