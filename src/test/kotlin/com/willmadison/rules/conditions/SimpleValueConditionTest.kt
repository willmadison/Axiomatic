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
        var condition = SimpleValueCondition(JXPathReader("items[sku='dummySku']/quantity"), Condition.Operator.EQUALS)
        condition.value = 5.0
        assertTrue(condition.evaluateCondition(exampleCart()))
    }

    @Test
    fun evaluateCondition_strictlyGreater() {
        var condition = SimpleValueCondition(JXPathReader("items[sku='dummySku']/quantity"), Condition.Operator.GREATER_THAN)
        condition.value = 1.0
        assertTrue(condition.evaluateCondition(exampleCart()))
    }

}