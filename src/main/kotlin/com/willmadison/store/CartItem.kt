package com.willmadison.store

data class CartItem(val upc: String = "", val sku: String = "", val quantity: Number = 0, var price: Number = 0)