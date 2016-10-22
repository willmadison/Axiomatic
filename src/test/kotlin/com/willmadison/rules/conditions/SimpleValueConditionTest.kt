package com.willmadison.rules.conditions

import com.willmadison.rules.Condition
import com.willmadison.rules.JXPathReader
import com.willmadison.store.exampleCart
import org.junit.Test

import org.junit.Assert.*

class SimpleValueConditionTest {

    @Test
    fun evaluateCondition_existence() {
        var condition = SimpleValueCondition(JXPathReader("items[sku='dummySku']"), Condition.Operator.EXISTS)
        assertTrue(condition.evaluateCondition(exampleCart()))

        condition = SimpleValueCondition(JXPathReader("items[sku='dummySku25']"), Condition.Operator.EXISTS)
        assertFalse(condition.evaluateCondition(exampleCart()))
    }

    @Test
    fun evaluateCondition_equals() {
        val condition = SimpleValueCondition(JXPathReader("items[sku='dummySku']/quantity"), Condition.Operator.EQUALS)
        condition.value = 5.0
        assertTrue(condition.evaluateCondition(exampleCart()))
    }

    @Test
    fun evaluateCondition_strictlyGreater() {
        val condition = SimpleValueCondition(JXPathReader("items[sku='dummySku']/quantity"), Condition.Operator.GREATER_THAN)
        condition.value = 1.0
        assertTrue(condition.evaluateCondition(exampleCart()))
    }

    @Test
    fun evaluateCondition_strictlyLess() {
        val condition = SimpleValueCondition(JXPathReader("items[sku='dummySku']/quantity"), Condition.Operator.LESS_THAN)
        condition.value = 100.0
        assertTrue(condition.evaluateCondition(exampleCart()))
    }

    @Test
    fun evaluateCondition_contains() {
        var condition = SimpleValueCondition(JXPathReader("promotions"), Condition.Operator.CONTAINS)
        condition.value = "promotion1"
        assertTrue(condition.evaluateCondition(exampleCart()))

        condition = SimpleValueCondition(JXPathReader("promotions"), Condition.Operator.CONTAINS)
        condition.value = "promotion70"
        assertFalse(condition.evaluateCondition(exampleCart()))
    }

    @Test
    fun evaluateCondition_containsForNonCollection() {
        val condition = SimpleValueCondition(JXPathReader("id"), Condition.Operator.CONTAINS)
        condition.value = "promotion1"
        assertFalse(condition.evaluateCondition(exampleCart()))
    }

}