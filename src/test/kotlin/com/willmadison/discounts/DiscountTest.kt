package com.willmadison.discounts

import com.willmadison.rules.buyNRule
import com.willmadison.store.exampleCart
import org.junit.Assert.*
import org.junit.Test

class DiscountTest {

    @Test
    fun isApplicable() {
        val cart = exampleCart()
        val noRule = Discount()
        val buy1Get1 = Discount(buyNRule(1, "dummySku1"))
        val buy7Get1 = Discount(buyNRule(7, "dummySku2"))

        assertFalse(noRule.isApplicable(cart))
        assertTrue(buy1Get1.isApplicable(cart))
        assertFalse(buy7Get1.isApplicable(cart))
    }
}