package com.willmadison.store

data class Cart(val items: Set<CartItem> = emptySet())