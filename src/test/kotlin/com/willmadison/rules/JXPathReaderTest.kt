package com.willmadison.rules

import com.willmadison.store.exampleCart
import org.junit.Test

import org.junit.Assert.*

class JXPathReaderTest {

    @Test
    fun read_valuePresentCanBeFound() {
        var reader = JXPathReader(path = "items[sku='dummySku1']")
        assertNotNull(reader.read(exampleCart()))
    }

    @Test
    fun read_valueNotPresentReturnsNull() {
        var reader = JXPathReader(path = "items[sku='dummySku17']")
        assertNull(reader.read(exampleCart()))
    }

    @Test
    fun read_quantityBasedSelectorReturns() {
        var reader = JXPathReader(path = "items[quantity=5.0]")
        assertNotNull(reader.read(exampleCart()))
    }

    @Test
    fun read_priceBasedSelectorReturns() {
        var reader = JXPathReader(path = "items[price=6.0]")
        assertNotNull(reader.read(exampleCart()))
    }

    @Test
    fun read_compoundCondition() {
        var reader = JXPathReader(path = "items[sku='dummySku' and quantity >= 1.0]")
        assertNotNull(reader.read(exampleCart()))

        reader = JXPathReader(path = "items[sku='dummySku' and quantity >= 10.0]")
        assertNull(reader.read(exampleCart()))
    }

}