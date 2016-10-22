package com.willmadison.store

import java.util.*

data class Cart(val items: Set<CartItem> = emptySet(), val promotions: Set<String> = emptySet(), val id: String = UUID.randomUUID().toString())

fun exampleCart() : Cart {
    return Cart(items = setOf(
            CartItem("dummyUpc", "dummySku", 5.0, 10.0),
            CartItem("dummyUpc1", "dummySku1", 7.0, 6.0),
            CartItem("dummyUpc2", "dummySku2", 3.0, 5.0)
    ), promotions =  setOf("promotion1", "promotion2"))
}